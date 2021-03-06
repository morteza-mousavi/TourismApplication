package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ir.reserveiran.mobile.tourismapplication.Location.GPSTracker;

public class MainActivity extends AppCompatActivity {

    DrawerLayout Drawer;
    NavigationView Side_menu;
    Button header_manu,header_search,header_alarm,hotel_btn,airplane_btn,scenery_btn,bus_btn,train_btn,btn_about_us,btn_login
           ,btn_home,btn_favorite ,btn_support;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawer = (DrawerLayout)findViewById(R.id.Drawer);
        Side_menu = (NavigationView)findViewById(R.id.Side_menu);
        header_manu = (Button)findViewById(R.id.header_manu);
        header_search = (Button)findViewById(R.id.header_search);
        header_alarm = (Button)findViewById(R.id.header_alarm);
        hotel_btn = (Button)findViewById(R.id.hotel_btn);
        airplane_btn = (Button)findViewById(R.id.airplane_btn);
        scenery_btn = (Button)findViewById(R.id.scenery_btn);
        bus_btn = (Button)findViewById(R.id.bus_btn);
        train_btn = (Button)findViewById(R.id.train_btn);

        btn_about_us = (Button)findViewById(R.id.btn_about_us);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_favorite = (Button)findViewById(R.id.btn_favorite);
        btn_support = (Button)findViewById(R.id.btn_support);








       btn_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity(intent);
            }
        });

         btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

       /* btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });*/

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),FavoriteActivity.class);
                startActivity(intent);
            }
        });

        btn_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SupportActivity.class);
                startActivity(intent);
            }
        });








        hotel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),HotelSearch.class);
                startActivity(intent);


            }
        });

        airplane_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),AirplaineActivity.class);
                startActivity(intent);


            }
        });

        scenery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SceneryActivity.class);
                startActivity(intent);


            }
        });

        bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BusActivity.class);
                startActivity(intent);


            }
        });

        train_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),TraineActivity.class);
                startActivity(intent);


            }
        });




        header_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        header_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Side_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;


            }
        });
        // Intent i = new Intent(getApplicationContext(),HotelSearch.class);
        // startActivity(i);
    }



}

