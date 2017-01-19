package ir.reserveiran.mobile.tourismapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ir.reserveiran.mobile.tourismapplication.Model.CityResponseModel;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/19/2017.
 */

public class AdapterCitySpinner  extends BaseAdapter implements SpinnerAdapter {

    private Context mContext;
    private ArrayList<CityResponseModel> mCityList;

    public AdapterCitySpinner(Context mContext, ArrayList<CityResponseModel> mCalendarsList) {

        this.mContext = mContext;
        this.mCityList = mCalendarsList;
    }

    @Override
    public int getCount() {
        return mCityList.size();
    }

    @Override
    public CityResponseModel getItem(int position) {
        return mCityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CityResponseModel o = mCityList.get(position);

        LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.item_city_row, null);

        TextView cityName = (TextView) convertView.findViewById(R.id.item_cityName);
        TextView cityId = (TextView) convertView.findViewById(R.id.item_cityId);

        cityId.setText(o.getCityId());
        cityName.setText(o.getCityName());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        CityResponseModel o = mCityList.get(position);

        LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.item_city_row, null);

        //convertView = LayoutInflater.from(mContext).inflate(R.layout.sp_item_calendar, null);

        TextView cityName = (TextView) convertView.findViewById(R.id.item_cityName);
        TextView cityId = (TextView) convertView.findViewById(R.id.item_cityId);
        cityId.setText(o.getCityId());
        cityName.setText(o.getCityName());

        return convertView;
    }
}
