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

public class BusActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    Spinner SpinnerCityName;
    Button btn_about_us,btn_login,btn_home,btn_favorite ,btn_support,btn_plus,btn_mines,search_btn;
    TextView txt_night_couter,hotel_date;

    int CityID = 21;
    String FromDate ;
    int night = 1;


    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        FromDate = year + "/" + ((int) monthOfYear + 1) + "/" + dayOfMonth;


        Log.e("Date = ", FromDate);
        hotel_date.setText(FromDate);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        txt_night_couter = (TextView) findViewById(R.id.txt_night_couter);
        hotel_date = (TextView) findViewById(R.id.hotel_date);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_mines = (Button)findViewById(R.id.btn_mines);

        btn_about_us = (Button)findViewById(R.id.btn_about_us);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_favorite = (Button)findViewById(R.id.btn_favorite);
        btn_support = (Button)findViewById(R.id.btn_support);


        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (night<10)
                {
                    night++;
                    txt_night_couter.setText(night+"");
                }


            }
        });

        btn_mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (night>1)
                {
                    night--;
                    txt_night_couter.setText(night+"");
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
                night=Integer.parseInt(txt_night_couter.getText().toString());


                Intent SearchResultActivity = new Intent(getApplicationContext(), HotelSearchResult.class);
                SearchResultActivity.putExtra("CityID", CityID);
                SearchResultActivity.putExtra("FromFaDate", FromDate);
                SearchResultActivity.putExtra("night", night);

                startActivity(SearchResultActivity);
            }
        });


        hotel_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                DatePickerDailog dp = new DatePickerDailog(HotelSearch.this,
                        dateandtime, new DatePickerDailog.DatePickerListner() {

                    // @SuppressLint("SimpleDateFormat")
                    @Override
                    public void OnDoneButton(Dialog datedialog, String c) {
                        datedialog.dismiss();

                        hotel_date.setText(c.toString());
                    }

                    @Override
                    public void OnCancelButton(Dialog datedialog) {
                        // TODO Auto-generated method stub
                        datedialog.dismiss();
                    }
                });
                dp.show();*/




                PersianCalendar persianCalendar = new PersianCalendar();
                persianCalendar.setPersianDate(persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay());
                DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                        BusActivity.this,
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
                                new CityAdapter(BusActivity.this,
                                        R.layout.item_city_row, cityResponseModelList);
                        SpinnerCityName.setAdapter(adapter);

                    }

                }
                progress.dismiss();
       /* Log.e("Cities Response Code : ",responseCode+"");*/
            }

            @Override
            public void onFailure(Call<CitiesResponseModel> call, Throwable t) {
                Log.e("Cities Response Code : ", " Error On Get Data");
            }
        });

        SpinnerCityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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



    }

}
