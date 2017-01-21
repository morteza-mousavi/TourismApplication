package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Morteza on 1/22/2017.
 */

public class HotelPriceListResponse {

    @SerializedName("HotelPriceResponse")
    @Expose
    public List<HotelPriceResponse> HotelPriceResponse ;

    @SerializedName("Error")
    @Expose
    public ErrorClass Error ;



    public ErrorClass getError() {
        return Error;
    }

    public void setError(ErrorClass error) {
        Error = error;
    }

    public List<HotelPriceResponse> getHotelPriceResponse() {
        return HotelPriceResponse;
    }

    public void setHotelPriceResponse(List<HotelPriceResponse> hotelPriceResponse) {
        HotelPriceResponse = hotelPriceResponse;
    }


}
