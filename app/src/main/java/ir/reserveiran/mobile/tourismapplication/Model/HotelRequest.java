package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Morteza on 1/20/2017.
 */

public class HotelRequest {

    @SerializedName("Token")
    @Expose
    public String Token ;

    @SerializedName("CityID")
    @Expose
    public int CityID ;

    @SerializedName("Calture")
    @Expose
    public String Calture ;

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public String getCalture() {
        return Calture;
    }

    public void setCalture(String calture) {
        Calture = calture;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    @SerializedName("FromDate")
    @Expose
    public Date FromDate ;
}
