package com.example.migaliza.chakula_user;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salifu on 11/24/2015.
 */
public class MealsAdapter extends ArrayAdapter<Meal> {
    private final Activity context;
    private final ArrayList<Meal> meals;



    public static class ViewHolder {
        public View mView;
        public TextView meal_idV;
        public TextView meal_nameV;
        public TextView meal_priceV;
        public TextView cafeteria;
        public Meal meal;

        public  ViewHolder(View view) {
            //super(view);
            mView = view;
            meal_nameV = (TextView) view.findViewById(R.id.meal_name);
            meal_priceV = (TextView) view.findViewById(R.id.meal_price);
            meal_idV = (TextView) view.findViewById(R.id.meal_id);
            cafeteria = (TextView) view.findViewById(R.id.cafeteria);
        }
    }


    public MealsAdapter(Activity context, ArrayList<Meal> meals) {
        super(context, R.layout.single_meal, meals);
        this.context = context;
        this.meals = meals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = LayoutInflater.from(context).inflate(R.layout.single_meal,
                    null, false);
            //rowView = inflater.inflate(R.layout.single_meal, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder(rowView);
            viewHolder.cafeteria = (TextView) rowView.findViewById(R.id.cafeteria);
            viewHolder.meal_nameV = (TextView) rowView.findViewById(R.id.meal_name);
            viewHolder.meal_idV = (TextView) rowView.findViewById(R.id.meal_id);
            viewHolder.meal_priceV = (TextView) rowView.findViewById(R.id.meal_price);
            //viewHolder.image = (ImageView) rowView.findViewById(R.id.ImageView01);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        Meal mymeal = meals.get(position);
        //holder.meal = s;
        holder.meal_priceV.setText(mymeal.price);
        holder.meal_nameV.setText(mymeal.mealName);
        holder.meal_idV.setText(mymeal.mealId);
        holder.cafeteria.setText(mymeal.cafeteria);

        return rowView;
    }
}