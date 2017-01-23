package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AirplaineActivity extends AppCompatActivity {

    Button btn_about_us,btn_login,btn_home,btn_favorite ,btn_support,search_btn,btn_adult_plus,btn_adult_minus,btn_child_plus
            ,btn_child_minus,btn_baby_plus,btn_baby_minus;
    TextView txt_adult_value,txt_child_value,txt_baby_value;

    int Adult = 1;
    int Child,Baby;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplaine);


        btn_adult_plus = (Button)findViewById(R.id.btn_adult_plus);
        txt_adult_value = (TextView) findViewById(R.id.txt_adult_value);
        btn_adult_minus = (Button)findViewById(R.id.btn_adult_minus);

        btn_child_plus = (Button)findViewById(R.id.btn_child_plus);
        txt_child_value = (TextView) findViewById(R.id.txt_child_value);
        btn_child_minus = (Button)findViewById(R.id.btn_child_minus);

        btn_baby_plus = (Button)findViewById(R.id.btn_baby_plus);
        txt_baby_value = (TextView) findViewById(R.id.txt_baby_value);
        btn_baby_minus = (Button)findViewById(R.id.btn_baby_minus);


        btn_about_us = (Button)findViewById(R.id.btn_about_us);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_favorite = (Button)findViewById(R.id.btn_favorite);
        btn_support = (Button)findViewById(R.id.btn_support);

        search_btn = (Button) findViewById(R.id.search_btn);


        btn_adult_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Adult <5 ){
                    Adult++;
                    txt_adult_value.setText(Adult+"");
                }

            }
        });

        btn_adult_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Adult >0 ){
                    Adult--;
                    txt_adult_value.setText(Adult+"");
                }

            }
        });


        btn_child_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Child <5 ){
                    Child++;
                    txt_child_value.setText(Child+"");
                }

            }
        });

        btn_child_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Child >0 ){
                    Child--;
                    txt_child_value.setText(Child+"");
                }

            }
        });


        btn_baby_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Baby <5 ){
                    Baby++;
                    txt_baby_value.setText(Baby+"");
                }

            }
        });

        btn_baby_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Baby >0 ){
                    Baby--;
                    txt_baby_value.setText(Baby+"");
                }

            }
        });






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


    }
}
