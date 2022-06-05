package com.assignment.uber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentImageOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_one, container, false);

        if(getArguments() != null){
            int img = getArguments().getInt("0");
            String name = getArguments().getString("00");
            String address = getArguments().getString("000");

            ImageView imgView = v.findViewById(R.id.iv_image_one);
            TextView tv_name = v.findViewById(R.id.name_fragment_one);
            TextView tv_address = v.findViewById(R.id.street_fragment_one);

            imgView.setImageResource(img);
            tv_name.setText(name);
            tv_address.setText(address);
        }
        return v;
    }
}