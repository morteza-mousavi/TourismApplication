package ir.reserveiran.mobile.tourismapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Adapters.ListHotelAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.HotelListResponses;
import ir.reserveiran.mobile.tourismapplication.Model.HotelRequest;
import ir.reserveiran.mobile.tourismapplication.Model.HotelResponse;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.Utility.JalaliCalendar;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search_result);

        final RecyclerView R_Hotel_List = (RecyclerView) findViewById(R.id.R_Hotel_List);
        final ProgressDialog progress = ProgressDialog.show(this, "ارتباط با سرور",
                "در حال دریافت اطلاعات هتلها ، لطفاً شکیبا باشید", true);


        ServiceApi serviceApi = new ServiceApi(getApplicationContext());
        ApiKeyManagement apiKeyManagement = new ApiKeyManagement(getApplicationContext());
        int CityID = 0;
        int night = 0;
        Date FromDate = new Date();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CityID = extras.getInt("CityID");
            String FromFaDate = extras.getString("FromFaDate");
            night = extras.getInt("night");
            //The key argument here must match that used in the other activity
            String[] i = FromFaDate.split("/");
            JalaliCalendar.YearMonthDate gdate = JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDate(Integer.parseInt(i[0]), Integer.parseInt(i[1]), Integer.parseInt(i[2])));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar calendar = new GregorianCalendar(gdate.getYear(), gdate.getMonth(), gdate.getDate());
            Log.e("Calender : ", sdf.format(calendar.getTime()) + "");

            FromDate = calendar.getTime();
            Log.e("From Date :::: ", FromDate + "");
        }

        HotelRequest hotelRequest = new HotelRequest();

        hotelRequest.setToken(apiKeyManagement.GetApiKey());
        hotelRequest.setCityID(CityID);
        hotelRequest.setCalture("fa");
        hotelRequest.setFromDate(FromDate);

        Call<HotelListResponses> responseCall = serviceApi.reservationApi.GetHotelsInCity(hotelRequest);
        responseCall.enqueue(new Callback<HotelListResponses>() {
            @Override
            public void onResponse(Call<HotelListResponses> call, Response<HotelListResponses> response) {
                Log.e("On Response :::>", response.code()+"");
                HotelListResponses hotelResponses =response.body();
                List<HotelResponse> r = hotelResponses.getHotelResponse();
                ListHotelAdapter adapter=new ListHotelAdapter(r,getApplicationContext());
                R_Hotel_List.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


                R_Hotel_List.setAdapter(adapter);
                /*try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
progress.dismiss();
            }

            @Override
            public void onFailure(Call<HotelListResponses> call, Throwable t) {
                Log.e("On Failure :::>", t.getMessage());

            }
        });


    }
}
