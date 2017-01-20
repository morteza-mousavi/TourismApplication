package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Morteza on 1/20/2017.
 */

public class HotelListResponses {
    @SerializedName("ErrorClass")
    @Expose
    public ErrorClass ErrorClass;

    public List<ir.reserveiran.mobile.tourismapplication.Model.HotelResponse> getHotelResponse() {
        return HotelResponse;
    }

    public void setHotelResponse(List<ir.reserveiran.mobile.tourismapplication.Model.HotelResponse> hotelResponse) {
        HotelResponse = hotelResponse;
    }

    public ir.reserveiran.mobile.tourismapplication.Model.ErrorClass getErrorClass() {
        return ErrorClass;
    }

    public void setErrorClass(ir.reserveiran.mobile.tourismapplication.Model.ErrorClass errorClass) {
        ErrorClass = errorClass;
    }

    @SerializedName("HotelResponse")
    @Expose
    public List<HotelResponse> HotelResponse;



}
