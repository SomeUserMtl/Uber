package com.assignment.uber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.assignment.uber.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dots.setupWithViewPager(binding.featuredFragmentContainer);

        featuredImageFragment();
        RestaurantListFragment();
    }

    private void featuredImageFragment() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        int fragmentAmt = 3;
        int size = Sort.sortByFeatured().size();

        if (fragmentAmt < size)
            size = fragmentAmt;

        for (int i = 0; i < size; i++) {
            FeaturedImageFragment fragment = new FeaturedImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        FeaturedImageAdapter adapter =
                new FeaturedImageAdapter(getSupportFragmentManager(), fragments);
        binding.featuredFragmentContainer.setAdapter(adapter);
    }

    private void RestaurantListFragment() {
        Fragment fragment = new RestaurantListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sorting_menu, menu);
        return true;
    }
}