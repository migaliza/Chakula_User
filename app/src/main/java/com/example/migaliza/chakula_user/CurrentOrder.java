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

    public String getOrder_details(){
        return this.getOrder_details();
    }

    public String getPrice(){
        return this.meal_price;
    }

    public String getTimestamp(){
        return this.timestamp;
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return order_details;
    }
}
