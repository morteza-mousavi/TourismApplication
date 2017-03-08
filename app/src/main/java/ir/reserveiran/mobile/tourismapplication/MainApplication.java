package ir.reserveiran.mobile.tourismapplication;

import android.app.Application;
import android.content.Context;

import ir.reserveiran.mobile.tourismapplication.Helpers.LocaleHelper;

/**
 * Created by Morteza on 3/8/2017.
 */

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
