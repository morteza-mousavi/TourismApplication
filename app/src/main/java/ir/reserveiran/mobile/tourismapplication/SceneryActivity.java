package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SceneryActivity extends AppCompatActivity {


    Button btn_about_us,btn_login,btn_home,btn_favorite ,btn_support,Near_btn,City_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);



/*        btn_about_us = (Button)findViewById(R.id.btn_about_us);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_favorite = (Button)findViewById(R.id.btn_favorite);
        btn_support = (Button)findViewById(R.id.btn_support);*/

        Near_btn = (Button)findViewById(R.id.Near_btn);
        City_btn = (Button)findViewById(R.id.City_btn);



        Near_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MapActivityTest.class);
                startActivity(intent);
            }
        });

        City_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity(intent);*/
            }
        });



/*
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

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

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
*/



    }
}
