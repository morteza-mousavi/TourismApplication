package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DrawerLayout Drawer;
    NavigationView Side_menu;
    Button header_manu,header_search,header_alarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawer = (DrawerLayout)findViewById(R.id.Drawer);
        Side_menu = (NavigationView)findViewById(R.id.Side_menu);
        header_manu = (Button)findViewById(R.id.header_manu);
        header_search = (Button)findViewById(R.id.header_search);
        header_alarm = (Button)findViewById(R.id.header_alarm);





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

