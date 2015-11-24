package com.example.migaliza.chakula_user;

/**
 * Created by Salifu on 11/24/2015.
 */
public class OrderHistory {

    public String order_details;
    public String meal_price;
    public String timestamp;

    public OrderHistory(String order_details, String meal_price, String timestamp) {
        this.order_details = order_details;
        this.meal_price = meal_price;
        this.timestamp = timestamp;
    }
}