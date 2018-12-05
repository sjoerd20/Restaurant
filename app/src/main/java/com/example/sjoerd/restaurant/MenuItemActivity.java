package com.example.sjoerd.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MenuItemActivity extends AppCompatActivity {

    private MenuItem retrievedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        // receive intent
        Intent intent = getIntent();
        retrievedMenu = (MenuItem) intent.getSerializableExtra("menu_item");

        // draw image
        ImageView image = findViewById(R.id.menuImage);
        Picasso.with(this).load(retrievedMenu.getImageURL()).into(image);

        TextView titleView = findViewById(R.id.menuTitleView);
        TextView priceView = findViewById(R.id.menuPriceView);
        TextView descriptionView = findViewById(R.id.menuDescriptionView);

        String priceText = "€" + String.valueOf(retrievedMenu.getPrice());
        priceView.setText(priceText);
        titleView.setText(retrievedMenu.getName());
        descriptionView.setText(retrievedMenu.getDescription());
    }
}
