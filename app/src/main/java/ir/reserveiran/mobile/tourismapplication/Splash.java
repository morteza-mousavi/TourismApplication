package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent intent  =  new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}
