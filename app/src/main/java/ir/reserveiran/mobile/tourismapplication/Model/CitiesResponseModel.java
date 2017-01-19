package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Morteza on 1/19/2017.
 */

public class CitiesResponseModel {

    @SerializedName("CityResponse")
    @Expose
    public List<CityResponseModel> CityResponse;

    public ErrorClass getError() {
        return Error;
    }

    public void setError(ErrorClass error) {
        Error = error;
    }

    public List<CityResponseModel> getCityResponse() {
        return CityResponse;
    }

    public void setCityResponse(List<CityResponseModel> cityResponse) {
        CityResponse = cityResponse;
    }

    @SerializedName("Error")
    @Expose
    public ErrorClass Error;
}
