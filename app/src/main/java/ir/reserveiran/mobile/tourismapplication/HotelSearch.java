package ir.reserveiran.mobile.tourismapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Adapters.CityAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.CitiesResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;
import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.TokenRequest;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSearch extends AppCompatActivity {

    Spinner SpinnerCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        ServiceApi serviceApi = new ServiceApi(getApplicationContext());

        SpinnerCityName = (Spinner) findViewById(R.id.SpinnerCityName);

        TokenRequest tokenRequest = new TokenRequest();
        ApiKeyManagement apiKeyManagement = new ApiKeyManagement(getApplicationContext());

        //Log.e("Api Key From : ",apiKeyManagement.GetApiKey());
        tokenRequest.setToken(apiKeyManagement.GetApiKey());

        final Call<CitiesResponseModel> citiesResponseModelCall = serviceApi.reservationApi.Cities(tokenRequest);

        citiesResponseModelCall.enqueue(new Callback<CitiesResponseModel>() {
            @Override
            public void onResponse(Call<CitiesResponseModel> call, Response<CitiesResponseModel> response) {

                int responseCode = response.code();
                if (response.isSuccessful()) {
                    CitiesResponseModel responseModelCall = response.body();
                    ErrorClass errorClass = responseModelCall.getError();
                    if (errorClass.getErrorId() == 0) {
                        List<CityResponseModel> cityResponseModelList = responseModelCall.getCityResponse();

                        CityAdapter adapter =
                                new CityAdapter(HotelSearch.this,
                                        R.layout.item_city_row, cityResponseModelList);
                        SpinnerCityName.setAdapter(adapter);

                    }

                }

       /* Log.e("Cities Response Code : ",responseCode+"");*/
            }

            @Override
            public void onFailure(Call<CitiesResponseModel> call, Throwable t) {
                Log.e("Cities Response Code : ", " Error On Get Data");
            }
        });

/*        SpinnerCityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Item selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }
}
