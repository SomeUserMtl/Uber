package com.assignment.uber;
import java.util.ArrayList;

public class Sort {
    public static void sortByLowPrice(ArrayList<Restaurant> restaurants) {

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

    public static void sortByHighPrice(ArrayList<Restaurant> restaurants) {
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

    public static void sortByRating(ArrayList<Restaurant> restaurants) {
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

    public static ArrayList<Restaurant> sortByVegan(ArrayList<Restaurant> restaurants) {
        //create new array of only vegan restaurants
        ArrayList<Restaurant> veganRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.isVegetarian()) {
                veganRestaurants.add(restaurant);
            }
        }
        return veganRestaurants;
    }
}
