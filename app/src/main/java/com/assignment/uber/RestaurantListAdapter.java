package com.assignment.uber;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class RestaurantListAdapter extends BaseAdapter {
    ArrayList<Restaurant> data;
    Context m_context;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> data){
        this.data = data;
        this.m_context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(m_context,R.layout.restaurant_list_item, null);

            //banner
            ImageView iv_banner = v.findViewById(R.id.imageView);
            if (iv_banner != null)
                iv_banner.setImageResource(data.get(i).getBannerImage());
            if (i == 0) {
                ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) Objects.requireNonNull(iv_banner).getLayoutParams();
                marginParams.setMargins(10, 0, 10, 10);
            }


            //name
            TextView tv_name = v.findViewById(R.id.tv_name);
            if (tv_name != null) {
                String name = data.get(i).getName() + ",";
                tv_name.setText(name);
            }

            //street
            TextView tv_street = v.findViewById(R.id.tv_street);
            if (tv_street != null){
                String street = data.get(i).getAddress1() + ",";
                tv_street.setText(street);
            }

            //city
            TextView tv_city = v.findViewById(R.id.tv_city);
            if (tv_city != null)
                tv_city.setText(data.get(i).getCity());

            //delivery fee
            TextView tv_delivery_fee = v.findViewById(R.id.tv_delivery_fee);
            if (tv_delivery_fee != null) {
                String minPrice = "$" + data.get(i).getMinPrice() + " Minimum Price -";
                tv_delivery_fee.setText(minPrice);
            }

            //rating
            TextView tv_rating = v.findViewById(R.id.tv_rating);
            if (tv_rating != null)
                tv_rating.setText(String.valueOf(data.get(i).getRating()));

            //delivery time
            TextView tv_delivery_time = v.findViewById(R.id.tv_delivery_time);
            if (tv_delivery_time != null) {
                String deliveryTime = data.get(i).getDeliveryTime() + " minutes";
                tv_delivery_time.setText(deliveryTime);
            }

            //vegan
            TextView tv_vegan = v.findViewById(R.id.tv_vegan_icon);
            if(data.get(i).isVegetarian()) {
                tv_vegan.setBackgroundResource(R.drawable.vegan_resource);
                Objects.requireNonNull(tv_delivery_fee).setPadding(10,0,0,0);
            }
            return v;
    }
}
