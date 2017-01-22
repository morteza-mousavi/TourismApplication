package ir.reserveiran.mobile.tourismapplication.Utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Morteza on 1/21/2017.
 */

public class Localization {

    public static void SetLocalization(Context context,String language_code)
    {
        Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);
    }

    public static Date ConvertToEnDate(String FromFaDate)
    {
        //The key argument here must match that used in the other activity
        String[] i = FromFaDate.split("/");
        JalaliCalendar.YearMonthDate gdate = JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDate(Integer.parseInt(i[0]), Integer.parseInt(i[1]), Integer.parseInt(i[2])));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = new GregorianCalendar(gdate.getYear(), gdate.getMonth(), gdate.getDate());
        Log.e("Calender : ", sdf.format(calendar.getTime()) + "");
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy"); //

       Date FromDate = calendar.getTime();
        Log.e("From Date :::: ", FromDate + "");

        return FromDate;

    }
}
