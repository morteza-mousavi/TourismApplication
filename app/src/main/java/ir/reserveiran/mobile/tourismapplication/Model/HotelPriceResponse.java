package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Morteza on 1/22/2017.
 */

public class HotelPriceResponse {

    @SerializedName("HotelID")
    @Expose
    public int HotelID ;

    @SerializedName("HotelServiceID")
    @Expose
    public int HotelServiceID ;

    @SerializedName("RoomTypeID")
    @Expose
    public int RoomTypeID ;

    @SerializedName("RoomTypeServiceID")
    @Expose
    public int RoomTypeServiceID ;

    @SerializedName("RoomTypeName")
    @Expose
    public String RoomTypeName ;

    @SerializedName("FromDate")
    @Expose
    public Date FromDate ;

    @SerializedName("FromFaDate")
    @Expose
    public String FromFaDate ;

    @SerializedName("ToDate")
    @Expose
    public Date ToDate ;

    @SerializedName("ToFaDate")
    @Expose
    public String ToFaDate ;

    @SerializedName("RackPriceAVG")
    @Expose
    public float RackPriceAVG ;

    @SerializedName("SellPriceAVG")
    @Expose
    public float SellPriceAVG ;

    @SerializedName("DiscountAVG")
    @Expose
    public float DiscountAVG ;

    @SerializedName("ExtraBedAVG")
    @Expose
    public float ExtraBedAVG ;

    @SerializedName("CapMin")
    @Expose
    public int CapMin ;

    @SerializedName("PointTotal")
    @Expose
    public int PointTotal ;

    @SerializedName("RackPriceSum")
    @Expose
    public float RackPriceSum ;

    public float getSellPriceSum() {
        return SellPriceSum;
    }

    public void setSellPriceSum(float sellPriceSum) {
        SellPriceSum = sellPriceSum;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int hotelID) {
        HotelID = hotelID;
    }

    public int getHotelServiceID() {
        return HotelServiceID;
    }

    public void setHotelServiceID(int hotelServiceID) {
        HotelServiceID = hotelServiceID;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        RoomTypeID = roomTypeID;
    }

    public int getRoomTypeServiceID() {
        return RoomTypeServiceID;
    }

    public void setRoomTypeServiceID(int roomTypeServiceID) {
        RoomTypeServiceID = roomTypeServiceID;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        RoomTypeName = roomTypeName;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public String getFromFaDate() {
        return FromFaDate;
    }

    public void setFromFaDate(String fromFaDate) {
        FromFaDate = fromFaDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }

    public String getToFaDate() {
        return ToFaDate;
    }

    public void setToFaDate(String toFaDate) {
        ToFaDate = toFaDate;
    }

    public float getRackPriceAVG() {
        return RackPriceAVG;
    }

    public void setRackPriceAVG(float rackPriceAVG) {
        RackPriceAVG = rackPriceAVG;
    }

    public float getSellPriceAVG() {
        return SellPriceAVG;
    }

    public void setSellPriceAVG(float sellPriceAVG) {
        SellPriceAVG = sellPriceAVG;
    }

    public float getDiscountAVG() {
        return DiscountAVG;
    }

    public void setDiscountAVG(float discountAVG) {
        DiscountAVG = discountAVG;
    }

    public float getExtraBedAVG() {
        return ExtraBedAVG;
    }

    public void setExtraBedAVG(float extraBedAVG) {
        ExtraBedAVG = extraBedAVG;
    }

    public int getCapMin() {
        return CapMin;
    }

    public void setCapMin(int capMin) {
        CapMin = capMin;
    }

    public int getPointTotal() {
        return PointTotal;
    }

    public void setPointTotal(int pointTotal) {
        PointTotal = pointTotal;
    }

    public float getRackPriceSum() {
        return RackPriceSum;
    }

    public void setRackPriceSum(float rackPriceSum) {
        RackPriceSum = rackPriceSum;
    }

    @SerializedName("SellPriceSum")
    @Expose
    public float SellPriceSum ;
}
