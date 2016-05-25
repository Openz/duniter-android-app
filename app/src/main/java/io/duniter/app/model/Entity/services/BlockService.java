package io.duniter.app.model.Entity.services;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.duniter.app.model.Entity.BlockUd;
import io.duniter.app.model.Entity.Currency;
import io.duniter.app.model.Entity.json.BlockJson;
import io.duniter.app.model.EntityWeb.BlockWeb;
import io.duniter.app.model.EntityWeb.CurrentBlockWeb;
import io.duniter.app.model.EntityWeb.UdWeb;
import io.duniter.app.model.services.WebService;
import io.duniter.app.technical.callback.CallbackBlock;
import io.duniter.app.technical.callback.CallbackUds;

/**
 * Created by naivalf27 on 21/04/16.
 */
public class BlockService {

    public static void getCurrentBlock(Context context, Currency currency, final CallbackBlock callback){
        CurrentBlockWeb currentBlockWeb  = new CurrentBlockWeb(context,currency);
        currentBlockWeb.getData(new WebService.WebServiceInterface() {
            @Override
            public void getDataFinished(int code, String response) {
                if(code ==200) {
                    BlockJson blockJson = BlockJson.fromJson(response);
                    BlockUd blockUd = BlockJson.fromBlock(blockJson);
                    callback.methode(blockUd);
                }
            }
        });
    }

    public static void getBlock(Context context, Currency currency, int number, final CallbackBlock callback){
        BlockWeb blockWeb = new BlockWeb(context,currency,number);
        blockWeb.getData(new WebService.WebServiceInterface() {
            @Override
            public void getDataFinished(int code, String response) {
                if (code==200) {
                    BlockJson blockJson = BlockJson.fromJson(response);
                    BlockUd blockUd = BlockJson.fromBlock(blockJson);
                    callback.methode(blockUd);
                }
            }
        });
    }

    public static void getListUdBlock(Context context, Currency currency, final CallbackUds callback){
        UdWeb udWeb = new UdWeb(context,currency);
        udWeb.getData(new WebService.WebServiceInterface() {
            @Override
            public void getDataFinished(int code, String response) {
                if (code==200){
                    try {
                        List<Integer> result = new ArrayList<Integer>();
                        JSONObject jsonObject = new JSONObject(response);
                        JSONObject jsonResult = jsonObject.getJSONObject("result");
                        JSONArray list = jsonResult.getJSONArray("blocks");
                        for(int i=0;i<list.length();i++){
                            result.add(list.getInt(i));
                        }
                        callback.methode(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
