package com.assignment.uber;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantListFragment extends Fragment {
    ArrayList<Restaurant> restaurants;
    View v;
    ListView menuList;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_restaurant_list, container, false);
        setHasOptionsMenu(true);
        menuList = v.findViewById(R.id.menu_list);
        restaurants = DataSource.getInstance().getRestaurantList();
        context = inflater.getContext();

        populateData(restaurants);
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Price - Low to high":
                Sort.sortByLowPrice();
                populateData(restaurants);
                return true;
            case "Price - High to low":
                Sort.sortByHighPrice();
                populateData(restaurants);
                return true;
            case "Rating":
                Sort.sortByRating();
                populateData(restaurants);
                return true;
            case "Vegan":
                populateData(Sort.sortByVegan());
                return true;
        }
        return false;
    }

    private void populateData(ArrayList<Restaurant> restaurants) {
        menuList.setAdapter(null);
        RestaurantListAdapter adapter = new RestaurantListAdapter(context, restaurants);
        menuList.setAdapter(adapter);
    }
}