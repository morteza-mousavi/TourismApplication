package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/19/2017.
 */

public class TokenRequest {

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    @SerializedName("Token")
    @Expose
    public String Token;
}
