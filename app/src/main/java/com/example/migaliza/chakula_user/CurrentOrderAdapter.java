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
public class CurrentOrderAdapter extends ArrayAdapter<CurrentOrder> {
    private final Activity context;
    private final ArrayList<CurrentOrder> currentOrders;



    public static class ViewHolder {
        public View mView;
        public TextView order_detailsV;
        public TextView meal_priceV;
        public TextView timestampV;
        public TextView statusV;
        public Meal meal;

        public  ViewHolder(View view) {
            //super(view);
            mView = view;
            order_detailsV = (TextView) view.findViewById(R.id.current_order_details);
            meal_priceV = (TextView) view.findViewById(R.id.current_meal_price);
            timestampV = (TextView) view.findViewById(R.id.current_timestamp);
            statusV= (TextView) view.findViewById(R.id.current_status);
        }
    }


    public CurrentOrderAdapter(Activity context, ArrayList<CurrentOrder> orders) {
        super(context, R.layout.current_order_row, orders);
        this.context = context;
        this.currentOrders = orders;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = LayoutInflater.from(context).inflate(R.layout.current_order_row,
                    null, false);
            //rowView = inflater.inflate(R.layout.single_meal, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder(rowView);
            viewHolder.order_detailsV = (TextView) rowView.findViewById(R.id.current_order_details);
            viewHolder.timestampV = (TextView) rowView.findViewById(R.id.current_timestamp);
            viewHolder.statusV = (TextView) rowView.findViewById(R.id.current_status);
            viewHolder.meal_priceV = (TextView) rowView.findViewById(R.id.current_meal_price);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        CurrentOrder myorder = currentOrders.get(position);
        //holder.meal = s;
        holder.meal_priceV.setText(myorder.meal_price);
        holder.statusV.setText(myorder.status);
        holder.order_detailsV.setText(myorder.order_details);
        holder.timestampV.setText(myorder.timestamp);
        return rowView;
    }
}
