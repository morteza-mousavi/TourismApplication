package ir.reserveiran.mobile.tourismapplication.Adapters;

import android.content.Context;
import android.graphics.Paint;
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

import ir.reserveiran.mobile.tourismapplication.Model.HotelPriceResponse;
import ir.reserveiran.mobile.tourismapplication.Model.HotelResponse;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/22/2017.
 */

public class ListRoomPriceAdapter extends RecyclerView.Adapter<ListRoomPriceAdapter.MyViewHolder> {


public class MyViewHolder extends RecyclerView.ViewHolder {


    public TextView txt_RoomTypeId,txt_RoomTypeName,txt_sumPriceAVGText,txt_rackPriceAVG,txt_SellPriceAVG,txt_sumPriceText,txt_rackPrice,txt_SellPrice,txt_roomDiscount,txt_roomPoint;
    public Button btnReserve;


    public MyViewHolder(View view) {
        super(view);

        txt_RoomTypeName = (TextView) view.findViewById(R.id.txt_RoomTypeName);
        txt_sumPriceAVGText = (TextView) view.findViewById(R.id.txt_sumPriceAVGText);
        txt_rackPriceAVG = (TextView) view.findViewById(R.id.txt_rackPriceAVG);
        txt_SellPriceAVG = (TextView) view.findViewById(R.id.txt_SellPriceAVG);
        txt_sumPriceText = (TextView) view.findViewById(R.id.txt_sumPriceText);
        txt_RoomTypeId=(TextView) view.findViewById(R.id.txt_RoomTypeId);
        txt_rackPrice = (TextView) view.findViewById(R.id.txt_rackPrice);
        txt_SellPrice = (TextView) view.findViewById(R.id.txt_SellPrice);
        txt_roomDiscount = (TextView) view.findViewById(R.id.txt_roomDiscount);
        txt_roomPoint = (TextView) view.findViewById(R.id.txt_roomPoint);

        btnReserve = (Button) view.findViewById(R.id.btnReserve);
    }
}

    Context mContext;
    private List<HotelPriceResponse> hotelPriceResponse;

    public ListRoomPriceAdapter(List<HotelPriceResponse> hotelPriceResponse, Context context) {
        this.hotelPriceResponse = hotelPriceResponse;
        mContext = context;
    }

    @Override
    public ListRoomPriceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_roomprice_rtl, parent, false);
        return new ListRoomPriceAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListRoomPriceAdapter.MyViewHolder holder, int position) {


        HotelPriceResponse h = hotelPriceResponse.get(position);
        holder.txt_RoomTypeName.setText(h.RoomTypeName);

        Typeface Font_BYekan = Typeface.createFromAsset(mContext.getAssets(), "fonts/byekan.ttf");
        holder.txt_RoomTypeName.setTypeface(Font_BYekan, Typeface.BOLD);
        holder.txt_RoomTypeName.setTextSize(15);


        holder.txt_sumPriceAVGText.setText("میانگین یک شب");
        holder.txt_rackPriceAVG.setText( h.RackPriceAVG + " تومان ");
        holder.txt_rackPriceAVG.setPaintFlags(holder.txt_rackPriceAVG.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.txt_SellPriceAVG.setText(h.SellPriceAVG+ " تومان " );

        holder.txt_sumPriceText.setText("قابل پرداخت");
        holder.txt_rackPrice.setText(h.RackPriceSum+ " تومان ");
        holder.txt_SellPrice.setText(h.SellPriceSum+ " تومان ");
        holder.txt_roomDiscount.setText(h.DiscountAVG+"% تخفیف");
        holder.txt_roomPoint.setText(h.PointTotal+" امتیاز ");

        holder.txt_RoomTypeId.setText(h.RoomTypeID + "");


/*
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
*/



        holder.btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("RoomTypeID :::>> ", holder.txt_RoomTypeId.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotelPriceResponse.size();
    }


}
