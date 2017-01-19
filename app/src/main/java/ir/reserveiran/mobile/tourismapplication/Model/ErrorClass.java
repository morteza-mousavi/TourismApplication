package ir.reserveiran.mobile.tourismapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Morteza on 1/19/2017.
 */

public class ErrorClass {

    @SerializedName("ErrorId")
    @Expose
    public int ErrorId;

    public String getErrorText() {
        return ErrorText;
    }

    public void setErrorText(String errorText) {
        ErrorText = errorText;
    }

    public int getErrorId() {
        return ErrorId;
    }

    public void setErrorId(int errorId) {
        ErrorId = errorId;
    }

    @SerializedName("ErrorText")
    @Expose
    public String ErrorText;
}
