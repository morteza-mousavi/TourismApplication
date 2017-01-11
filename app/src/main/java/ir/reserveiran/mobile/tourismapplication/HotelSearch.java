package ir.reserveiran.mobile.tourismapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HotelSearch extends AppCompatActivity {

    TextView TxtFromDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);


        TxtFromDate = (TextView) findViewById(R.id.TxtFromDate);
        TxtFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSearchDialogFragment();
/*
                Dialog searchDialog = new Dialog(HotelSearch.this);
                searchDialog.setContentView(R.layout.activity_search_dialog);
                searchDialog.setTitle("جستجوي شهر");

                searchDialog.show();
*/

/*                Intent i = new Intent(getApplicationContext(),SearchDialog.class);
                startActivity(i);
                Toast.makeText(HotelSearch.this, "كليك بر روي تكست ويو", Toast.LENGTH_SHORT).show();*/
            }
        });
    }
    private void showSearchDialogFragment() {
        FragmentManager fm = getSupportFragmentManager();
        SearchDialogFragment editNameDialog = new SearchDialogFragment();
        editNameDialog.show(fm, "fragment_edit_name");
    }

    public void onFinishSearchDialogFragment(String inputText) {
        Toast.makeText(this, "Hi, " + inputText, Toast.LENGTH_SHORT).show();
    }
}
