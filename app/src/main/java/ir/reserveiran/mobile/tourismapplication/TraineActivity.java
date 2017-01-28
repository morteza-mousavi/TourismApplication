package ir.reserveiran.mobile.tourismapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Adapters.CityAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.CitiesResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.TokenRequest;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraineActivity extends AppCompatActivity{ /*implements DatePickerDialog.OnDateSetListener {*/


    Spinner SpinnerFromCityName,SpinnerToCityName;
    Button btn_about_us,btn_login,btn_home,btn_favorite ,btn_support,search_btn,btn_adult_plus,
            btn_adult_minus,btn_child_plus,btn_child_minus,btn_baby_plus,btn_baby_minus,btn_veteran_plus,btn_veteran_minus;

    TextView txt_adult_value,txt_child_value,txt_baby_value,txt_veteran_value;

    int CityID = 21;
    String FromDate ;
    int Adult = 1;
    int Child,Baby,Veteran;


  /*  public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        FromDate = year + "/" + ((int) monthOfYear + 1) + "/" + dayOfMonth;


        Log.e("Date = ", FromDate);
        hotel_date.setText(FromDate);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traine);



        btn_adult_plus = (Button)findViewById(R.id.btn_adult_plus);
        txt_adult_value = (TextView) findViewById(R.id.txt_adult_value);
        btn_adult_minus = (Button)findViewById(R.id.btn_adult_minus);

        btn_child_plus = (Button)findViewById(R.id.btn_child_plus);
        txt_child_value = (TextView) findViewById(R.id.txt_child_value);
        btn_child_minus = (Button)findViewById(R.id.btn_child_minus);

        btn_baby_plus = (Button)findViewById(R.id.btn_baby_plus);
        txt_baby_value = (TextView) findViewById(R.id.txt_baby_value);
        btn_baby_minus = (Button)findViewById(R.id.btn_baby_minus);

        btn_veteran_plus = (Button)findViewById(R.id.btn_veteran_plus);
        txt_veteran_value = (TextView) findViewById(R.id.txt_veteran_value);
        btn_veteran_minus = (Button)findViewById(R.id.btn_veteran_minus);

        btn_about_us = (Button)findViewById(R.id.btn_about_us);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_favorite = (Button)findViewById(R.id.btn_favorite);
        btn_support = (Button)findViewById(R.id.btn_support);

        search_btn = (Button) findViewById(R.id.search_btn);



        btn_adult_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Adult <6 ){
                    Adult++;
                    txt_adult_value.setText(Adult+"");
                }

            }
        });

        btn_adult_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Adult >0 ){
                    Adult--;
                    txt_adult_value.setText(Adult+"");
                }

            }
        });


        btn_child_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Child <6 ){
                    Child++;
                    txt_child_value.setText(Child+"");
                }

            }
        });

        btn_child_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Child >0 ){
                    Child--;
                    txt_child_value.setText(Child+"");
                }

            }
        });




        btn_veteran_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Veteran <6 ){
                    Veteran++;
                    txt_veteran_value.setText(Veteran+"");
                }

            }
        });

        btn_veteran_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Veteran >0 ){
                    Veteran--;
                    txt_veteran_value.setText(Veteran+"");
                }

            }
        });




        btn_baby_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Baby <6 ){
                    Baby++;
                    txt_baby_value.setText(Baby+"");
                }

            }
        });

        btn_baby_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Baby >0 ){
                    Baby--;
                    txt_baby_value.setText(Baby+"");
                }

            }
        });




        btn_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),FavoriteActivity.class);
                startActivity(intent);
            }
        });

        btn_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SupportActivity.class);
                startActivity(intent);
            }
        });


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                night=Integer.parseInt(txt_night_couter.getText().toString());


                Intent SearchResultActivity = new Intent(getApplicationContext(), HotelSearchResult.class);
                SearchResultActivity.putExtra("CityID", CityID);
                SearchResultActivity.putExtra("FromFaDate", FromDate);
                SearchResultActivity.putExtra("night", night);

                startActivity(SearchResultActivity);*/
            }
        });

/*

        hotel_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PersianCalendar persianCalendar = new PersianCalendar();
                persianCalendar.setPersianDate(persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay());
                DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                        TraineActivity.this,
                        persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay()
                );
                datePickerDialog.setThemeDark(true);
                datePickerDialog.setMinDate(persianCalendar);
                datePickerDialog.show(getFragmentManager(), "Datepickerdialog");


            }

        });



        final ProgressDialog progress = ProgressDialog.show(this, "دریافت اطلاعات از سرور",
                "در حال ارتباط با سرور ، لطفاً شکیبا باشید", true);
        ServiceApi serviceApi = new ServiceApi(getApplicationContext());

        SpinnerFromCityName = (Spinner) findViewById(R.id.SpinnerFromCityName);
        SpinnerToCityName = (Spinner) findViewById(R.id.SpinnerToCityName);

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
                                new CityAdapter(TraineActivity.this,
                                        R.layout.item_city_row, cityResponseModelList);
                        SpinnerFromCityName.setAdapter(adapter);
                        SpinnerToCityName.setAdapter(adapter);

                    }

                }
                progress.dismiss();
       */
/* Log.e("Cities Response Code : ",responseCode+"");*//*

            }

            @Override
            public void onFailure(Call<CitiesResponseModel> call, Throwable t) {
                Log.e("Cities Response Code : ", " Error On Get Data");
            }
        });

        SpinnerFromCityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView Txt_CityName = (TextView) view.findViewById(R.id.item_cityName);
                TextView Txt_CityId = (TextView) view.findViewById(R.id.item_cityId);

                String Text = Txt_CityName.getText().toString() + " ==> " + Txt_CityId.getText().toString();
                //Toast.makeText(HotelSearch.this, Text, Toast.LENGTH_SHORT).show();
                CityID=Integer.parseInt(Txt_CityId.getText().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        SpinnerToCityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */


    }


}
