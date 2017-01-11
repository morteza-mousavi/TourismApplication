package ir.reserveiran.mobile.tourismapplication.Model;

/**
 * Created by Morteza on 1/11/2017.
 */

public class CityViewModel {
    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int CityId;
    public String CityName;

/*    public CityViewModel(int cityid , String cityname)
    {
        this.CityId=cityid;
        this.CityName=cityname;
    }*/
}
