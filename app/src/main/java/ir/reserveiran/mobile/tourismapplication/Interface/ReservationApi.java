package ir.reserveiran.mobile.tourismapplication.Interface;

import ir.reserveiran.mobile.tourismapplication.Model.FirstParamRequest;
import ir.reserveiran.mobile.tourismapplication.Model.FirstParamResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Morteza on 1/19/2017.
 */

public interface ReservationApi {

    @POST("Api/GetFirstParams")
    Call<FirstParamResponse> GetTokenAccess(@Body FirstParamRequest firstParamRequest);
}
