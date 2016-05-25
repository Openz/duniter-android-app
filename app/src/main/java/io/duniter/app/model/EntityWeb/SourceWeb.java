package io.duniter.app.model.EntityWeb;

import android.content.Context;

import io.duniter.app.model.Entity.Currency;
import io.duniter.app.model.services.WebService;

/**
 * Created by naivalf27 on 19/04/16.
 */
public class SourceWeb extends Web{
    private Currency currency;
    private String publicKey;

    public SourceWeb(Context context, Currency currency, String publicKey) {
        super(context);
        this.currency = currency;
        this.publicKey = publicKey;
    }

    @Override
    public String getUrl() {
        return "http://" + WebService.getServeur(context,currency) + "/tx/sources/" + publicKey;
    }

    @Override
    public String postUrl() {
        return null;
    }
}
