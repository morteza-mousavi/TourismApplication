package ir.reserveiran.mobile.tourismapplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/11/2017.
 */

public class CityAdapter extends ArrayAdapter<CityViewModel> {

    Context mContext;
    LayoutInflater inflater;

    public CityAdapter(Context context, int resource, List<CityViewModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        view = inflater.inflate(R.layout.item_city_row, null);
        TextView cityName = (TextView) view.findViewById(R.id.cityName);
        TextView cityId = (TextView) view.findViewById(R.id.cityId);

        CityViewModel cityViewModel = getItem(position);

        cityName.setText(cityViewModel.getCityName());
        cityId.setText(cityViewModel.getCityId()+"");

        return view;
    }
}
