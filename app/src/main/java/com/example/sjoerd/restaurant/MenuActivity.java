package com.example.sjoerd.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // receive intent
        Intent intent = getIntent();
        String retrievedCategory = intent.getStringExtra("category_name");

        MenuRequest x = new MenuRequest(this, retrievedCategory);
        x.getMenus(this);
        Toast.makeText(this, retrievedCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotMenus(ArrayList<MenuItem> menuItems) {
        Toast.makeText(this, "some menu's", Toast.LENGTH_LONG).show();
    }

    @Override
    public void gotMenusError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
