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
        final ConnectivityManager connectivityManager = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
