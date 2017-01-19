package ir.reserveiran.mobile.tourismapplication.WebService;

import android.content.Context;

import ir.reserveiran.mobile.tourismapplication.Interface.ReservationApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Morteza on 1/19/2017.
 */

public class ServiceApi {
    public static String BASE_URL = "http://telegramapi.reserveiran.ir/";
    //public static String METHOD_GetFirstParams="Api/GetFirstParams";
    Context mContext;
    public  ReservationApi reservationApi;
    public ServiceApi(Context context) {
        mContext = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://telegramapi.reserveiran.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        reservationApi = retrofit.create(ReservationApi.class);
    }
}
