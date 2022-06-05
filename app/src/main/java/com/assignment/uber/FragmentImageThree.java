package com.assignment.uber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentImageThree extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_three, container, false);

        if(getArguments() != null){
            int img = getArguments().getInt("2");
            String name = getArguments().getString("22");
            String address = getArguments().getString("222");

            ImageView imgView = v.findViewById(R.id.iv_image_three);
            TextView tv_name = v.findViewById(R.id.name_fragment_three);
            TextView tv_address = v.findViewById(R.id.street_fragment_three);

            imgView.setImageResource(img);
            tv_name.setText(name);
            tv_address.setText(address);
        }

        return v;
    }
}