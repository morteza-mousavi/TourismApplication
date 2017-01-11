package ir.reserveiran.mobile.tourismapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.reserveiran.mobile.tourismapplication.Adapters.CityAdapter;
import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;

/**
 * Created by Morteza on 1/11/2017.
 */

public class SearchDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getActivity(), "item", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    public interface EditNameDialogListener {
        void onFinishSearchDialogFragment(String inputText);
    }

    public SearchDialogFragment() {
        // Empty constructor required for DialogFragment
    }
    EditText edt_searchTerm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_dialog,container);

        ArrayList<CityViewModel> cityArray = new ArrayList<>();

        CityViewModel c = new CityViewModel();
        c.setCityId(21);
        c.setCityName("تهران");
        cityArray.add(c);

         edt_searchTerm = (EditText) view.findViewById(R.id.edt_searchTerm);
        getDialog().setTitle("Hello");



        CityAdapter adapter = new CityAdapter(getActivity(),0,cityArray);

        ListView listView =(ListView)view.findViewById(R.id.listviewCity);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cityid=(TextView) view.findViewById(R.id.cityId);
                //Toast.makeText(getActivity(), cityid.getText(), Toast.LENGTH_SHORT).show();



                //EditNameDialogListener activity = (EditNameDialogListener) getActivity();
               //activity.onFinishSearchDialogFragment("");
                //dismiss();
            }
        });


        return view ;
    }
}
