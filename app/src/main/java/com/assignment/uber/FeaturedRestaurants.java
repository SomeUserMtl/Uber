package com.assignment.uber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FeaturedRestaurants {
    private final ArrayList<Restaurant> featuredRestaurants = DataSource.getInstance().getFeaturedRestaurants();
    private final HashMap<Integer, Integer> featuredIndex = new HashMap<>();

    public ArrayList<Fragment> getFeaturedFragments() {
        randomIndex();

        ArrayList<Fragment> featuredFragments = new ArrayList<>();
        featuredFragments.add(new FragmentImageOne());
        featuredFragments.add(new FragmentaImageTwo());
        featuredFragments.add(new FragmentImageThree());

        int i = 0;
        for (Fragment fragment : featuredFragments) {
            Bundle b = new Bundle();
            b.putInt("" + i, featuredRestaurants.get(featuredIndex.get(i)).getBannerImage());
            b.putString(i + "" + i, featuredRestaurants.get(featuredIndex.get(i)).getName());
            b.putString(i + "" + i + "" + i, featuredRestaurants.get(featuredIndex.get(i)).getAddress1());
            fragment.setArguments(b);
            i++;
        }
        return featuredFragments;
    }

    private void randomIndex() {
        Random random = new Random();

        while (featuredIndex.size() < 3) {
            int index = random.nextInt(featuredRestaurants.size());
            if (!featuredIndex.containsValue(index)) {
                featuredIndex.put(featuredIndex.size(), index);
            }
        }
    }
}
