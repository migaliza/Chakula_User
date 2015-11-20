package com.example.migaliza.chakula_user;

/**
 * Created by Salifu on 11/18/2015.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class OrderHistory {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Order> ORDERS = new ArrayList<Order>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Order> ORDER_MAP = new HashMap<>();

    //get order history here from database
    private static int user_id = 58062016;

    public static String[] thehistory = {"Banku 12 10/12/12", "Fufu 11.9 12/10/10"};

    static {
        // Add 3 sample items.
        Controller mycontrol = new Controller();
        String url = "http://192.168.56.1/chakula/controller/ajax-action.php?cmd=22&user_id="+user_id;
        mycontrol.execute("history", url);
        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        String[] history = mycontrol.getHistory();
        if(history != null) {
            System.out.println("Length of array is " + history.length);

            for (int i = 0; i < history.length; i++) {
                addItem(new Order(history[i]));
            }
        }else{
            System.out.println("History array is null");
        }
    }

    private static void addItem(Order order) {
        ORDERS.add(order);
        ORDER_MAP.put(order.order_details, order);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Order {
        public String order_details;

        public Order(String order_details) {
            this.order_details = order_details;

        }

        @Override
        public String toString() {
            return order_details;
        }
    }
}

