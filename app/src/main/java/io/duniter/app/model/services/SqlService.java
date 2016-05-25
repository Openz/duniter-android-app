package io.duniter.app.model.services;

import android.content.Context;

import io.duniter.app.model.EntitySql.BlockUdSql;
import io.duniter.app.model.EntitySql.CertificationSql;
import io.duniter.app.model.EntitySql.ContactSql;
import io.duniter.app.model.EntitySql.CurrencySql;
import io.duniter.app.model.EntitySql.EndpointSql;
import io.duniter.app.model.EntitySql.IdentitySql;
import io.duniter.app.model.EntitySql.PeerSql;
import io.duniter.app.model.EntitySql.RequirementSql;
import io.duniter.app.model.EntitySql.SourceSql;
import io.duniter.app.model.EntitySql.TxSql;
import io.duniter.app.model.EntitySql.WalletSql;

/**
 * Created by naivalf27 on 05/04/16.
 */
public class SqlService {

    public static CurrencySql getCurrencySql(Context context) {
        return new CurrencySql(context);
    }

    public static BlockUdSql getBlockSql(Context context) {
        return new BlockUdSql(context);
    }

    public static IdentitySql getIdentitySql(Context context) {
        return new IdentitySql(context);
    }

    public static WalletSql getWalletSql(Context context) {
        return new WalletSql(context);
    }

    public static ContactSql getContactSql(Context context) {
        return new ContactSql(context);
    }

    public static RequirementSql getRequirementSql(Context context) { return new RequirementSql(context); }

    public static CertificationSql getCertificationSql(Context context) { return new CertificationSql(context); }

    public static TxSql getTxSql(Context context){ return new TxSql(context);}

    public static PeerSql getPeerSql(Context context){
        return new PeerSql(context);
    }

    public static EndpointSql getEndpointSql(Context context) {
        return new EndpointSql(context);
    }

    public static SourceSql getSourceSql(Context context){ return new SourceSql(context);}
}
