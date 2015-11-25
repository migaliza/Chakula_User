package com.example.migaliza.chakula_user;

/**
 * Created by Salifu on 11/24/2015.
 */
public class CurrentOrder {

    public String order_details;
    public String meal_price;
    public String timestamp;
    public String status;


    public CurrentOrder(String order_details, String meal_price, String timestamp, String status) {
        this.order_details = order_details;
        this.meal_price = meal_price;
        this.timestamp = timestamp;
        this.status = status;
    }
}
