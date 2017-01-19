package ir.reserveiran.mobile.tourismapplication.Utility;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Morteza on 1/19/2017.
 */

public class CheckStatusClass {
    Context mContext;

    public CheckStatusClass(Context context) {
        mContext = context;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm;
        cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
