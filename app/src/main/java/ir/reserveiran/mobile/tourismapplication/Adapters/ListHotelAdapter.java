package ir.reserveiran.mobile.tourismapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.reserveiran.mobile.tourismapplication.HotelRoomsResult;
import ir.reserveiran.mobile.tourismapplication.HotelSearchResult;
import ir.reserveiran.mobile.tourismapplication.Model.HotelResponse;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/20/2017.
 */

public class ListHotelAdapter extends RecyclerView.Adapter<ListHotelAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RatingBar hotel_grade;
        public ImageView img_Hotel;
        public TextView Txt_hotelName, txt_hotel_discount, txt_hotel_start_price_from, Txt_hotel_address, txt_hotelId;
        public Button btnNext;


        public MyViewHolder(View view) {
            super(view);
            hotel_grade = (RatingBar) view.findViewById(R.id.hotel_grade);
            img_Hotel = (ImageView) view.findViewById(R.id.img_Hotel);
            Txt_hotelName = (TextView) view.findViewById(R.id.Txt_hotelName);
            txt_hotel_discount = (TextView) view.findViewById(R.id.txt_hotel_discount);
            txt_hotel_start_price_from = (TextView) view.findViewById(R.id.txt_hotel_start_price_from);
            Txt_hotel_address = (TextView) view.findViewById(R.id.Txt_hotel_address);
            txt_hotelId = (TextView) view.findViewById(R.id.txt_hotelId);
            btnNext = (Button) view.findViewById(R.id.btnNext);
        }
    }

    Context mContext;
    private List<HotelResponse> hotelResponse;

    public ListHotelAdapter(List<HotelResponse> hotelResponse, Context context) {
        this.hotelResponse = hotelResponse;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel_row_rtl, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        HotelResponse h = hotelResponse.get(position);
        holder.Txt_hotelName.setText(h.HotelName);

        Typeface Font_BYekan = Typeface.createFromAsset(mContext.getAssets(), "fonts/byekan.ttf");
        holder.Txt_hotelName.setTypeface(Font_BYekan, Typeface.BOLD);
        holder.Txt_hotelName.setTextSize(15);


        holder.txt_hotel_discount.setText(h.MaxDiscout + "% تخفیف");
        holder.txt_hotel_start_price_from.setText(" شروع قیمت از " + h.MinPrice + " تومان ");
        holder.Txt_hotel_address.setText(h.HotelAddress);


        holder.txt_hotelId.setText(h.HotelID + "");
        String imageUri = "http://www.reserveiran.ir" + h.Pic;
        Picasso.with(mContext)
                .load(imageUri)
                .into(holder.img_Hotel, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        holder.img_Hotel.setImageResource(R.mipmap.ic_launcher);
                    }
                });

        holder.hotel_grade.setNumStars(h.HotelGrade);

        holder.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("FromFaDate :::>> ", HotelSearchResult.FromFaDate);

                Intent RoomIntent = new Intent(mContext, HotelRoomsResult.class);
                RoomIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                RoomIntent.putExtra("HotelID",Integer.parseInt(holder.txt_hotelId.getText().toString()));
                RoomIntent.putExtra("FromFaDate", HotelSearchResult.FromFaDate);
                RoomIntent.putExtra("night",HotelSearchResult.night);

                mContext.startActivity(RoomIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotelResponse.size();
    }


}
