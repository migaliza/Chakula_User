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

    static {
        // Add 3 sample items.
        addItem(new Order("1", "banku hist"));
        addItem(new Order("2", "Waakye ist"));
        addItem(new Order("3", "Dorkuni hist"));
    }

    private static void addItem(Order order) {
        ORDERS.add(order);
        ORDER_MAP.put(order.id, order);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Order {
        public String id;
        public String content;

        public Order(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}

