package ir.reserveiran.mobile.tourismapplication.Utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;

/**
 * Created by Morteza on 1/19/2017.
 */

public class CheckStatusClass {
    Context mContext;

    public CheckStatusClass(Context context) {
        mContext = context;
    }

    public boolean isNetworkConnected() {
        boolean enabled = true;

        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        if ((info == null || !info.isConnected() || !info.isAvailable())) {

            //Toast.makeText(getApplicationContext(), "Sin conexión a Internet...", Toast.LENGTH_SHORT).show();
            enabled = false;
        } else {
            enabled =true;//conexión
        }

        return enabled;
    }
    public boolean isHostRechable(String hostUrl) {
        try {
            URL url = new URL(hostUrl);
            final HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestProperty("User-Agent", "Android Application");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(10 * 1000);
            urlc.connect();
            if (urlc.getResponseCode() == 200) {
                return true;
            }
        } catch (Throwable e) {
            Log.d("Connection = > ",e.getMessage());
            //e.printStackTrace();
        }
        return false;
    }
}
