package com.example.sjoerd.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // set listener
        ListView listView = findViewById(R.id.categoriesListView);
        listView.setOnItemClickListener(new OnItemClickListener());

        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
    }

    private class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            intent.putExtra("category_name", view.getId());
            startActivity(intent);
        }
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {
        Toast.makeText(this, categories.get(0), Toast.LENGTH_LONG).show();

        // create simple array adapter
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                categories);
        ListView listView = findViewById(R.id.categoriesListView);
        listView.setAdapter(categoriesAdapter);
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
