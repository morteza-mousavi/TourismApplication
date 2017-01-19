package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/19/2017.
 */

public class FirstParamRequest {

    @SerializedName("DeviceId")
    @Expose
    public String DeviceId;
    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }


/*
    public String getPushId() {
        return PushId;
    }

    public void setPushId(String pushId) {
        PushId = pushId;
    }
*/



/*    @SerializedName("PushId")
    @Expose
    public String PushId;*/
}
