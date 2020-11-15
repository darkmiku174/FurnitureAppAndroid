package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textViewDescription;
    ImageView img;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        utils = new Utils(getApplication());
        Intent intent = getIntent();
        Furniture furniture = (Furniture) intent.getSerializableExtra("furniture");
        textViewDescription = findViewById(R.id.textViewDescription);
        img = findViewById(R.id.imageViewProduct);

        getSupportActionBar().setTitle(furniture.getName());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DD1709")));
        textViewDescription.setText(furniture.getDescription());
        img.setImageBitmap(Furniture.convertStringToBitmapFromAccess(getApplication(), furniture.getImage()));
    }
}