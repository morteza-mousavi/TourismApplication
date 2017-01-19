package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/19/2017.
 */

public class CityResponseModel {

    @SerializedName("CityId")
    @Expose
    public int CityId;

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    @SerializedName("CityName")
    @Expose
    public String CityName;
}
