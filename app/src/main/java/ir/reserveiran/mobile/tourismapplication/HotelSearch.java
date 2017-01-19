package ir.reserveiran.mobile.tourismapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;

public class HotelSearch extends AppCompatActivity {

    Spinner SpinnerCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        SpinnerCityName=(Spinner) findViewById(R.id.SpinnerCityName);

        List<CityViewModel>  cities;

    }
}
