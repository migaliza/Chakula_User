package com.example.migaliza.chakula_user;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salifu on 11/24/2015.
 */
public class HistoryAdapter extends ArrayAdapter<OrderHistory> {

    private final Activity context;
    private final ArrayList<OrderHistory> histories;



    public static class ViewHolder {
        public View mView;
        public TextView order_detailV;
        public TextView timestampV;
        public TextView meal_priceV;
        public Meal meal;

        public  ViewHolder(View view) {
            //super(view);
            mView = view;
            order_detailV = (TextView) view.findViewById(R.id.hist_order_details);
            meal_priceV = (TextView) view.findViewById(R.id.hist_meal_price);
            timestampV = (TextView) view.findViewById(R.id.hist_timestamp);
        }
    }


    public HistoryAdapter(Activity context, ArrayList<OrderHistory> histories) {
        super(context, R.layout.history_row, histories);
        this.context = context;
        this.histories = histories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = LayoutInflater.from(context).inflate(R.layout.history_row,
                    null, false);
            //rowView = inflater.inflate(R.layout.single_meal, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder(rowView);
            viewHolder.order_detailV = (TextView) rowView.findViewById(R.id.hist_order_details);
            viewHolder.meal_priceV = (TextView) rowView.findViewById(R.id.hist_meal_price);
            viewHolder.timestampV = (TextView) rowView.findViewById(R.id.hist_timestamp);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        OrderHistory hist = histories.get(position);
        holder.timestampV.setText(hist.timestamp);
        holder.order_detailV.setText(hist.order_details);
        holder.timestampV.setText("Ghc "+hist.meal_price);
        return rowView;
    }
}
