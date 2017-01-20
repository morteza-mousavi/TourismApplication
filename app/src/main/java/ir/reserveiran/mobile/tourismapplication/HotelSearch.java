package ir.reserveiran.mobile.tourismapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import org.w3c.dom.Text;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Adapters.CityAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.CitiesResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;
import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.TokenRequest;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.Utility.DatePickerDailog;
import ir.reserveiran.mobile.tourismapplication.Utility.JalaliCalendar;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSearch extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Spinner SpinnerCityName;
    JalaliCalendar dateandtime;
    TextView hotel_date, txt_night_couter;
    Button search_btn;

    int CityID = 21;
    String FromDate ;
    int night = 1;


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        FromDate = year + "/" + ((int) monthOfYear + 1) + "/" + dayOfMonth;


        Log.e("Date = ", FromDate);
        hotel_date.setText(FromDate);

/*        JalaliCalendar.YearMonthDate gdate = JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDate(year, monthOfYear, dayOfMonth));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = new GregorianCalendar(gdate.getYear(), gdate.getMonth(), gdate.getDate());
        Log.e("Calender : ", sdf.format(calendar.getTime()) + "");*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);
        txt_night_couter = (TextView) findViewById(R.id.txt_night_couter);
        hotel_date = (TextView) findViewById(R.id.hotel_date);
        search_btn = (Button) findViewById(R.id.search_btn);



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
                        HotelSearch.this,
                        persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay()
                );
                datePickerDialog.setThemeDark(true);
                datePickerDialog.setMinDate(persianCalendar);
                datePickerDialog.show(getFragmentManager(), "Datepickerdialog");


            }

        });



final ProgressDialog progress = ProgressDialog.show(this, "dialog title",
        "dialog message", true);
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
                Toast.makeText(HotelSearch.this, Text, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
