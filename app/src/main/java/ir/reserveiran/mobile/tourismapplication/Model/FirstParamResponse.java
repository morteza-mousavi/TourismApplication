package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/19/2017.
 */

public class FirstParamResponse {

    @SerializedName("ApiKey")
    @Expose
    public String ApiKey;

    public ErrorClass getError() {
        return Error;
    }

    public void setError(ErrorClass error) {
        Error = error;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    @SerializedName("Error")
    @Expose
    public ErrorClass Error;
}
