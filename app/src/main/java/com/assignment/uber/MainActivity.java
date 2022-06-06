package com.assignment.uber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.assignment.uber.databinding.ActivityMainBinding;

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
        FeaturedImageAdapter adapter = new FeaturedImageAdapter(
                getSupportFragmentManager(),
                Sort.sortByFeatured());
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