package ir.reserveiran.mobile.tourismapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.reserveiran.mobile.tourismapplication.Adapters.CityAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;

public class SearchDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dialog);

        ArrayList<CityViewModel> cityArray = new ArrayList<>();

        CityViewModel c = new CityViewModel();
        c.setCityId(21);
        c.setCityName("تهران");
        cityArray.add(c);


        CityAdapter adapter = new CityAdapter(getApplicationContext(),0,cityArray);

        ListView listView =(ListView)findViewById(R.id.listviewCity);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cityid=(TextView) view.findViewById(R.id.cityId);
                Toast.makeText(SearchDialog.this, cityid.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        //Toast.makeText(this, cityArray.get(0).getCityName(), Toast.LENGTH_SHORT).show();



    }
}
