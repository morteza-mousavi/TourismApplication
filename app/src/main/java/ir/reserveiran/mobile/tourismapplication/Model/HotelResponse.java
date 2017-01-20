package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/20/2017.
 */

public class HotelResponse {

    @SerializedName("HotelID")
    @Expose
    public int HotelID ;

    @SerializedName("HotelName")
    @Expose
    public String HotelName ;

    @SerializedName("HotelGrade")
    @Expose
    public int HotelGrade ;

    @SerializedName("Pic")
    @Expose
    public String Pic ;

    @SerializedName("MaxDiscout")
    @Expose
    public double MaxDiscout ;

    @SerializedName("MinPrice")
    @Expose
    public double MinPrice ;

    @SerializedName("HotelInfo")
    @Expose
    public String HotelInfo ;

    @SerializedName("HotelAddress")
    @Expose
    public String HotelAddress ;

    @SerializedName("Latitiude")
    @Expose
    public double Latitiude ;

    public double getLongititude() {
        return Longititude;
    }

    public void setLongititude(double longititude) {
        Longititude = longititude;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int hotelID) {
        HotelID = hotelID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public int getHotelGrade() {
        return HotelGrade;
    }

    public void setHotelGrade(int hotelGrade) {
        HotelGrade = hotelGrade;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public double getMaxDiscout() {
        return MaxDiscout;
    }

    public void setMaxDiscout(double maxDiscout) {
        MaxDiscout = maxDiscout;
    }

    public double getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(double minPrice) {
        MinPrice = minPrice;
    }

    public String getHotelInfo() {
        return HotelInfo;
    }

    public void setHotelInfo(String hotelInfo) {
        HotelInfo = hotelInfo;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        HotelAddress = hotelAddress;
    }

    public double getLatitiude() {
        return Latitiude;
    }

    public void setLatitiude(double latitiude) {
        Latitiude = latitiude;
    }

    @SerializedName("Longititude")
    @Expose
    public double Longititude ;
}
