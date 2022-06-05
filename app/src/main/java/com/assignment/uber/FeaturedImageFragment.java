package com.assignment.uber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FeaturedImageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_featured_image, container, false);

        if(getArguments() != null){
            int index = getArguments().getInt("key");
            Restaurant restaurant = DataSource.getInstance().getRestaurant(index);

                ImageView imgView = v.findViewById(R.id.iv_img_fragment);
                TextView tv_name = v.findViewById(R.id.tv_name_fragment);
                TextView tv_address = v.findViewById(R.id.tv_address_fragment);

                imgView.setImageResource(restaurant.getBannerImage());
                tv_name.setText(restaurant.getName());
                tv_address.setText(restaurant.getAddress1());
        }

        return v;
    }
}