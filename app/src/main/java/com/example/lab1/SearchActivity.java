package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    TextView textView;
    ArrayList<Furniture> arrayList;
    Utils utils;
    DBHelper dbHelper;
    ListView listView;
    FurnitureAdapter furnitureAdapter;
    TagGroup mTagGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //utils = new Utils(SearchActivity.this);
        dbHelper = new DBHelper(SearchActivity.this);
        textView = findViewById(R.id.textViewResult);
        arrayList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        furnitureAdapter = new FurnitureAdapter(SearchActivity.this, arrayList);
        listView.setAdapter(furnitureAdapter);

        searchView = findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchFurniture(newText);
                return false;
            }
        });
        mTagGroup = findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Bed", "Living",
                "Accessories", "Sealy", "Christopher"});
        mTagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                searchView.setQuery(tag, false);
                hideSoftKeyboard(searchView);
            }
        });
    }

    private void searchFurniture(String newText) {
        if (newText == null)
            return;
        ArrayList<Furniture> tmp = new ArrayList<>();
//        for (Furniture furniture : utils.LoadFileInternal()) {
//            if (furniture.getName().toLowerCase().contains(newText.toLowerCase())) {
//                tmp.add(furniture);
//            }
//        }
        for (Furniture furniture : dbHelper.getALLFurniture()) {
            if (furniture.getName().toLowerCase().contains(newText.toLowerCase())) {
                tmp.add(furniture);
            }
        }
//        Toast.makeText(this, tmp.size() + "", Toast.LENGTH_SHORT).show();
        textView = findViewById(R.id.textViewResult);
        if (tmp.size() > 0) {
            furnitureAdapter.clear();
            textView.setVisibility(View.INVISIBLE);
            furnitureAdapter.addAll(tmp);
            furnitureAdapter.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
        }
        if (newText.isEmpty()) {
            listView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}