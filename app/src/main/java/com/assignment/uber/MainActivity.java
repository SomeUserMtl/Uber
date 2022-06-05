package com.assignment.uber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;

import com.assignment.uber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        featuredFragment();
        menuFragment();

        binding.dots.setupWithViewPager(binding.featuredFragmentContainer);
    }

    private void featuredFragment() {
        FeaturedImageAdapter adapter = new FeaturedImageAdapter(
                getSupportFragmentManager(),
                new FeaturedRestaurants().getFeaturedFragments());
        binding.featuredFragmentContainer.setAdapter(adapter);
    }

    private void menuFragment() {
        Fragment fragment = new RestaurantsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_fragment_container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sorting_menu, menu);
        return true;
    }
}