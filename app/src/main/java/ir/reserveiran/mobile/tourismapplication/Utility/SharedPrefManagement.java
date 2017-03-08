package ir.reserveiran.mobile.tourismapplication.Utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Morteza on 3/8/2017.
 */

public class SharedPrefManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefManagement(Context context,String Key) {
        sharedPreferences = context.getSharedPreferences(Key, context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetApiKey(String Key,String value) {
        editor.putString(Key, value);
        editor.commit();
    }

    public String GetApiKey(String Key){
        return sharedPreferences.getString(Key,"");
    }
}
