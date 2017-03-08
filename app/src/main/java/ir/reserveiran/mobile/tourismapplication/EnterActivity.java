package ir.reserveiran.mobile.tourismapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ir.reserveiran.mobile.tourismapplication.Helpers.LocaleHelper;
import ir.reserveiran.mobile.tourismapplication.Utility.SharedPrefManagement;

public class EnterActivity extends AppCompatActivity {

    Button enter_btn, guest_btn, register_btn;
    EditText txt_user_name, txt_password;
    RadioButton App_Fa, App_En;
    String SelectedLang;
    RadioGroup RadioAppLang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        RadioAppLang = (RadioGroup) findViewById(R.id.RadioAppLang);

/*
        App_Fa =(RadioButton) findViewById(R.id.App_En);
        App_En =(RadioButton) findViewById(R.id.App_En);
*/

        RadioAppLang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton SelectedBtn = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                switch (SelectedBtn.getId()) {
                    case R.id.App_En:
                        SelectedLang = "en";
                        //attachBaseContext(getBaseContext());
                        break;

                    case R.id.App_Fa:
                        SelectedLang = "fa";
                        //attachBaseContext(getBaseContext());
                        break;
                }
                SharedPrefManagement sh = new SharedPrefManagement(getApplicationContext(), "SelectLang");
                sh.SetApiKey("SelectLang", SelectedLang);
                Intent i = new Intent(getApplicationContext(), Splash.class);
                startActivity(i);


            }
        });

        enter_btn = (Button) findViewById(R.id.enter_btn);
        guest_btn = (Button) findViewById(R.id.guest_btn);
        register_btn = (Button) findViewById(R.id.register_btn);

        txt_user_name = (EditText) findViewById(R.id.txt_user_name);
        txt_password = (EditText) findViewById(R.id.txt_password);


        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        guest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context base) {
        SharedPrefManagement sh = new SharedPrefManagement(base, "SelectLang");
        SelectedLang=sh.GetApiKey("SelectLang");
        Log.d("Select Lang =>",SelectedLang);
        super.attachBaseContext(LocaleHelper.onAttach(base,SelectedLang ));
        //Intent Start = new Intent(base,Splash.class);
    }
}
