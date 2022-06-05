package com.assignment.uber;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {
    ArrayList<Restaurant> restaurants;
    View v;
    ListView menuList;
    Context m_context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_menu, container, false);
        setHasOptionsMenu(true);
        menuList = v.findViewById(R.id.menu_list);
        restaurants = DataSource.getInstance().getRestaurantList();
        m_context = inflater.getContext();

        populateRestaurantList(restaurants);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.price_low_to_high:
                Sort.sortByLowPrice(restaurants);
                populateRestaurantList(restaurants);
                return true;
            case R.id.price_high_to_low:
                Sort.sortByHighPrice(restaurants);
                populateRestaurantList(restaurants);
                return true;
            case R.id.m_sort_rating:
                Sort.sortByRating(restaurants);
                populateRestaurantList(restaurants);
                return true;
            case R.id.m_sort_vegan:
                populateRestaurantList(Sort.sortByVegan(restaurants));
                return true;
            default:
                break;
        }
        return false;
    }

    private void populateRestaurantList(ArrayList<Restaurant> restaurants) {
        menuList.setAdapter(null);
        RestaurantListAdapter adapter = new RestaurantListAdapter(m_context, restaurants);
        menuList.setAdapter(adapter);
    }
}