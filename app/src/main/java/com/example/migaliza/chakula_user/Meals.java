package com.example.migaliza.chakula_user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
public class Meals {

    /**
     * An array of sample meals.
     */
    public static List<Meal> MEALS = new ArrayList<Meal>();

    /**
     * A map of sample meals, by ID.
     */
    public static Map<String, Meal> MEALS_MAP = new HashMap<>();

    //do the filling here

    static {
        // Add 3 sample items.
        addItem(new Meal("bNJ12", "Fufu", 3.4, "bigben", "yes"));
        addItem(new Meal("bNJ99", "Banku", 3.2, "akornor", "yes"));
        addItem(new Meal("b7239", "Waake", 5.2, "bigben", "yes"));
        addItem(new Meal("bN23", "Fufu tilapia", 3.4, "bigben", "yes"));
        addItem(new Meal("bNJADS", "Banku", 3.2, "akornor", "yes"));
        addItem(new Meal("bdfdfd", "Waake full", 5.2, "bigben", "yes"));
        addItem(new Meal("bNjjj", "Fufu full", 3.4, "bigben", "yes"));
        addItem(new Meal("bNiii", "Banku full", 3.2, "akornor", "yes"));
        addItem(new Meal("bppgh", "Waake and stew", 5.2, "bigben", "yes"));
        addItem(new Meal("bNewre9", "Kenkey", 3.4, "bigben", "yes"));
        addItem(new Meal("bN900ff", "Soakings", 3.2, "akornor", "yes"));
        addItem(new Meal("b7jnf", "Buffalo teeth", 5.2, "bigben", "yes"));
        addItem(new Meal("bNJ12", "Akple", 3.4, "bigben", "yes"));
        addItem(new Meal("bN345dd", "Burger", 3.2, "akornor", "yes"));
        addItem(new Meal("b724902", "French fries", 5.2, "bigben", "yes"));
    }

    /**
     *
     * @param meal
     */
    private static void addItem(Meal meal) {
        MEALS.add(meal);
        MEALS_MAP.put(meal.mealId, meal);
    }

    /**
     * A class representing a Meal.
     */
    public static class Meal {
        public String mealId;
        public String mealName;
        public double price;
        public String cafeteriaId;
        public String availability;

        /**
         *
         * @param meal_id
         * @param meal_name
         * @param price
         * @param cafeteria_id
         * @param availability
         */
        public Meal(String meal_id, String meal_name, double price, String cafeteria_id, String availability) {
            this.mealId = meal_id;
            this.mealName = meal_name;
            this.price = price;
            this.cafeteriaId = cafeteria_id;
            this.availability = availability;
        }

        @Override
        public String toString() {
            return mealName+"            "+cafeteriaId+"             "+price;
        }

    }
}
