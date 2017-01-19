package ir.reserveiran.mobile.tourismapplication;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.FirstParamRequest;
import ir.reserveiran.mobile.tourismapplication.Model.FirstParamResponse;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String Device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.d("Device_Id", Device_id);

        ServiceApi serviceApi = new ServiceApi(getApplicationContext());

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("PushId :  ", refreshedToken);

        FirstParamRequest request = new FirstParamRequest();
        request.setDeviceId(Device_id);
        request.setPushId(refreshedToken);


        Call<FirstParamResponse> responseCall = serviceApi.reservationApi.GetTokenAccess(request);
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
                }
                else {
                }
            }

            @Override
            public void onFailure(Call<FirstParamResponse> call, Throwable t) {
                Log.e("Error Code",   "Error ");
            }
        });


                new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
