package com.assignment.uber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentaImageTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_two, container, false);

        if(getArguments() != null){
            try{
                int img = getArguments().getInt("1");
                String name = getArguments().getString("11");
                String address = getArguments().getString("111");

                ImageView imgView = v.findViewById(R.id.iv_image_two);
                TextView tv_name = v.findViewById(R.id.name_fragment_two);
                TextView tv_address = v.findViewById(R.id.street_fragment_two);

                imgView.setImageResource(img);
                tv_name.setText(name);
                tv_address.setText(address);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return v;
    }
}