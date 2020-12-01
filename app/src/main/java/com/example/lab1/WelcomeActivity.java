package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        dbHelper =new DBHelper(this);
        dbHelper.createTable();
        ArrayList<Furniture> arrFur = dbHelper.getALLFurniture();
        if (arrFur.size() == 0) {
            dbHelper.insertFurniture();
        }
        ArrayList<Categories> arrCate = dbHelper.getALLCategories();
        if (arrCate.size() == 0) {
            dbHelper.insertCategories();
        }
//        dbHelper.addFurnitureToCategories();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}