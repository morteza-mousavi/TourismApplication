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

import ir.reserveiran.mobile.tourismapplication.Model.CityResponseModel;
import ir.reserveiran.mobile.tourismapplication.Model.CityViewModel;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/11/2017.
 */

public class CityAdapter extends ArrayAdapter<CityResponseModel> {

    Context mContext;
    LayoutInflater inflater;
    List<CityResponseModel> listobjects;

    public CityAdapter(Context context, int resource, List<CityResponseModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        listobjects=objects;
        inflater = LayoutInflater.from(mContext);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View item = inflater.inflate(R.layout.item_city_row, parent, false);
        TextView TxtCityName = (TextView) item.findViewById(R.id.item_cityName);
        TextView TxtCityId = (TextView) item.findViewById(R.id.item_cityId);

        TxtCityName.setText(listobjects.get(position).getCityName());
        TxtCityId.setText(listobjects.get(position).getCityId()+"");
        return item;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
