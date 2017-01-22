package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Morteza on 1/22/2017.
 */

public class HotelPriceRequest {

    @SerializedName("Token")
    @Expose
    public String Token ;

    @SerializedName("HotelID")
    @Expose
    public int HotelID ;

    public String getFromFaDate() {
        return FromFaDate;
    }

    public void setFromFaDate(String fromFaDate) {
        FromFaDate = fromFaDate;
    }

    @SerializedName("FromFaDate")
    @Expose
    public String FromFaDate;

    @SerializedName("Night")
    @Expose
    public int Night ;

    @SerializedName("Culture")
    @Expose
    public String Culture;


    public String getCulture() {
        return Culture;
    }

    public void setCulture(String culture) {
        Culture = culture;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int hotelID) {
        HotelID = hotelID;
    }


    public int getNight() {
        return Night;
    }

    public void setNight(int night) {
        Night = night;
    }


}
