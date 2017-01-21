package ir.reserveiran.mobile.tourismapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {

    Button btn_ir,btn_en,enter_btn,guest_btn,register_btn;
    EditText txt_user_name,txt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);


        btn_ir =(Button) findViewById(R.id.btn_ir);
        btn_en =(Button) findViewById(R.id.btn_en);

        enter_btn =(Button) findViewById(R.id.enter_btn);
        guest_btn =(Button) findViewById(R.id.guest_btn);
        register_btn =(Button) findViewById(R.id.register_btn);

        txt_user_name =(EditText) findViewById(R.id.txt_user_name);
        txt_password =(EditText) findViewById(R.id.txt_password);




        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



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
}
