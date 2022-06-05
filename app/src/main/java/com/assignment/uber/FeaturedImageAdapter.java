package com.assignment.uber;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FeaturedImageAdapter extends FragmentPagerAdapter {
    ArrayList<Restaurant> restaurants;

    public FeaturedImageAdapter(FragmentManager fm, ArrayList<Restaurant> restaurants) {
        super(fm);
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        FeaturedImageFragment fragment = new FeaturedImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}