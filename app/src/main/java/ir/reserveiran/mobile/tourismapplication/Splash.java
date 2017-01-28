package ir.reserveiran.mobile.tourismapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Locale;

import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.FirstParamRequest;
import ir.reserveiran.mobile.tourismapplication.Model.FirstParamResponse;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.Utility.CheckStatusClass;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("en"));

        
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        String Device_id =  Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d("Device_Id", Device_id);

        ServiceApi serviceApi = new ServiceApi(getApplicationContext());

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        if (refreshedToken == null)
        {
            refreshedToken=" ";
        }
        Log.d("PushId :  ", refreshedToken);


        FirstParamRequest request = new FirstParamRequest();
        request.setDeviceId(Device_id);
        /*request.setPushId(refreshedToken);*/

        CheckStatusClass statusClass = new CheckStatusClass(getApplicationContext());
        boolean networkConnected = statusClass.isNetworkConnected();
        if (networkConnected) {
            Call<FirstParamResponse> responseCall = serviceApi.reservationApi.GetFirstParams(request);
            responseCall.enqueue(new Callback<FirstParamResponse>() {
                @Override
                public void onResponse(Call<FirstParamResponse> call, Response<FirstParamResponse> response) {
                    int StatusCode = response.code();
                    Log.e("Status Code", StatusCode + "");
                    if (response.isSuccessful()) {
                        FirstParamResponse paramResponse = response.body();
                        String ApiKey = paramResponse.getApiKey();
                        ErrorClass Errors = paramResponse.getError();

                        Log.i("ApiKey", ApiKey);
                        Log.i("Error Class Result", "Error ID : " + Errors.getErrorId() + " => " + Errors.getErrorText());


                        ApiKeyManagement apiKeyManagement = new ApiKeyManagement(getApplicationContext());
                        apiKeyManagement.SetApiKey(ApiKey);
                    } else {
                    }
                }

                @Override
                public void onFailure(Call<FirstParamResponse> call, Throwable t) {
                    Log.e("Error Code", "Error ");
                }
            });


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, EnterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 1000);

        } else {

            ShowConnectionDialog();
            //startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }
    }

    private void ShowConnectionDialog()
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);


       // adb.setView(alertDialogView);


        adb.setTitle("عدم برقراری ارتباط با اینترنت");
        adb.setMessage("جهت استفاده از برنامه نیاز به اتصال به اینترنت دارید");


        adb.setIcon(android.R.drawable.ic_dialog_alert);


        adb.setPositiveButton("ورود به تنظیمات اینترنت", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            } });


        adb.setNegativeButton("انصراف", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                finish();
            } });
        adb.show();
    }
}
