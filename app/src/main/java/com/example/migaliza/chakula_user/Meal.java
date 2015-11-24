package com.example.migaliza.chakula_user;

/**
 * Created by Salifu on 11/23/2015.
 */
public class Meal {

    public String mealId;
    public String mealName;
    public String price;
    public String cafeteria;
    public String availability;

    /**
     *
     * @param meal_id
     * @param meal_name
     * @param price
     * @param cafeteria
     * @param availability
     */
    public Meal(String meal_id, String meal_name, String price, String cafeteria, String availability) {
        this.mealId = meal_id;
        this.mealName = meal_name;
        this.price = price;
        this.cafeteria = cafeteria;
        this.availability = availability;
    }

    public String getMealName(){
        return this.mealName;
    }

    public String getPrice(){
        return this.price;
    }

    public String getCafeteria(){
        return this.cafeteria;
    }

    @Override
    public String toString() {
        return mealName+"            "+cafeteria+"             "+price;
    }
}