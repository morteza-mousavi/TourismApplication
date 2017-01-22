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
import ir.reserveiran.mobile.tourismapplication.Adapters.ListRoomPriceAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.ErrorClass;
import ir.reserveiran.mobile.tourismapplication.Model.HotelPriceListResponse;
import ir.reserveiran.mobile.tourismapplication.Model.HotelPriceRequest;
import ir.reserveiran.mobile.tourismapplication.Model.HotelPriceResponse;
import ir.reserveiran.mobile.tourismapplication.Utility.ApiKeyManagement;
import ir.reserveiran.mobile.tourismapplication.Utility.JalaliCalendar;
import ir.reserveiran.mobile.tourismapplication.Utility.Localization;
import ir.reserveiran.mobile.tourismapplication.WebService.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelRoomsResult extends AppCompatActivity {
    public static String FromFaDate;
    public static int night;
    public static int HotelID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_rooms_result);

        final RecyclerView R_RoomPrice_List = (RecyclerView) findViewById(R.id.R_RoomPrice_List);
        final ProgressDialog progress = ProgressDialog.show(this, "ارتباط با سرور",
                "در حال دریافت اطلاعات هتلها ، لطفاً شکیبا باشید", true);


        ServiceApi serviceApi = new ServiceApi(getApplicationContext());
        ApiKeyManagement apiKeyManagement = new ApiKeyManagement(getApplicationContext());



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            FromFaDate = extras.getString("FromFaDate");
            night = extras.getInt("night");
            HotelID=extras.getInt("HotelID");
        }
        //Date FromDate = Localization.ConvertToEnDate(FromFaDate);

        HotelPriceRequest hotelPriceRequest = new HotelPriceRequest();
        hotelPriceRequest.setCulture("fa");
        hotelPriceRequest.setFromFaDate(FromFaDate);
        hotelPriceRequest.setHotelID(HotelID);
        hotelPriceRequest.setToken(apiKeyManagement.GetApiKey());
        hotelPriceRequest.setNight(night);

        Call<HotelPriceListResponse> responseCall = serviceApi.reservationApi.HotelPriceSummery(hotelPriceRequest);
        responseCall.enqueue(new Callback<HotelPriceListResponse>() {
            @Override
            public void onResponse(Call<HotelPriceListResponse> call, Response<HotelPriceListResponse> response) {
                Log.e("On Response :::>", response.code()+"");
                HotelPriceListResponse hotelPriceListResponse = response.body();
                List<HotelPriceResponse> hotelPriceResponse=hotelPriceListResponse.getHotelPriceResponse();
                ErrorClass Error = hotelPriceListResponse.getError();

                ListRoomPriceAdapter adapter=new ListRoomPriceAdapter(hotelPriceResponse,getApplicationContext());
                R_RoomPrice_List.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                Log.e("RoomType Name ==>>",hotelPriceResponse.get(0).getRoomTypeName().toString());

                R_RoomPrice_List.setAdapter(adapter);

                progress.dismiss();
            }

            @Override
            public void onFailure(Call<HotelPriceListResponse> call, Throwable t) {

                Log.e("Room Result Failure:>>",t.getMessage());
                progress.dismiss();
            }
        });
    }
}
