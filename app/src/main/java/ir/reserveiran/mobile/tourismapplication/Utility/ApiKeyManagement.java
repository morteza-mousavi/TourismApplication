package ir.reserveiran.mobile.tourismapplication.Utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Morteza on 1/19/2017.
 */

public class ApiKeyManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public ApiKeyManagement(Context context) {
        sharedPreferences = context.getSharedPreferences("ApiKey", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetApiKey(String ApiKey) {
        editor.putString("ApiKey", ApiKey);
        editor.commit();
    }

    public String GetApiKey(){
        return sharedPreferences.getString("ApiKey","");
    }


}
