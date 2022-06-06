package com.assignment.uber;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    private static final ArrayList<Restaurant> restaurants
            = DataSource.getInstance().getRestaurantList();
    private static final ArrayList<Restaurant> featuredList = new ArrayList<>();
    private static boolean sorted;

    public static void sortByLowPrice() {
        //insertion sort
        for (int i = 1; i < restaurants.size(); i++) {
            Restaurant key = restaurants.get(i);
            int j = i - 1;
            while (j >= 0 && restaurants.get(j).getMinPrice() > key.getMinPrice()) {
                restaurants.set(j + 1, restaurants.get(j));
                j = j - 1;
            }
            restaurants.set(j + 1, key);
        }
    }

    public static void sortByHighPrice() {
        //insertion sort
        for (int i = 1; i < restaurants.size(); i++) {
            Restaurant key = restaurants.get(i);
            int j = i - 1;
            while (j >= 0 && restaurants.get(j).getMinPrice() < key.getMinPrice()) {
                restaurants.set(j + 1, restaurants.get(j));
                j = j - 1;
            }
            restaurants.set(j + 1, key);
        }
    }

    public static void sortByRating() {
        //insertion sort
        for (int i = 1; i < restaurants.size(); i++) {
            Restaurant key = restaurants.get(i);
            int j = i - 1;
            while (j >= 0 && restaurants.get(j).getRating() < key.getRating()) {
                restaurants.set(j + 1, restaurants.get(j));
                j = j - 1;
            }
            restaurants.set(j + 1, key);
        }
    }

    public static ArrayList<Restaurant> sortByVegan() {
        ArrayList<Restaurant> veganRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.isVegetarian()) {
                veganRestaurants.add(restaurant);
            }
        }
        return veganRestaurants;
    }

    public static ArrayList<Restaurant> sortByFeatured() {
        if (!sorted) {
            for (Restaurant restaurant : restaurants) {
                if (restaurant.isFeatured())
                    featuredList.add(restaurant);
            }
            Collections.shuffle(featuredList);
            sorted = true;
        }
        return featuredList;
    }
}