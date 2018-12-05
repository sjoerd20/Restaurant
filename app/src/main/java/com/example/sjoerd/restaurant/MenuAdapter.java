package com.example.sjoerd.restaurant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuItem> {

    private ArrayList<MenuItem> menuItems;

    // constructor
    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> objects) {
        super(context, resource, objects);
        this.menuItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent,
                    false);
        }

        // get current menu
        MenuItem menuItem = menuItems.get(position);

        // draw image
        ImageView image = convertView.findViewById(R.id.imageView);
//        Drawable imageDrawable = getContext().getResources().getDrawable(menuItem);
        Picasso.with(getContext()).load(menuItem.getImageURL()).into(image);

        TextView titleView = convertView.findViewById(R.id.titleView);
        TextView priceView = convertView.findViewById(R.id.priceView);

        titleView.setText(menuItem.getName());
        String priceText = "€" + String.valueOf(menuItem.getPrice());
        priceView.setText(priceText);

        return convertView;
    }
}
