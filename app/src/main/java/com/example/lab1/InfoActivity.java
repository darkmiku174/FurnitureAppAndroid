package com.example.lab1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    EditText editName, editEmail, editPass, editUser;
    RadioGroup rdbGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        editName = findViewById(R.id.editTextName);
        editEmail = findViewById(R.id.editTextEmail);
        editUser = findViewById(R.id.editTextUserName);
        editPass = findViewById(R.id.editTextPassword);
        getSupportActionBar().setTitle("Account Info");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        Intent intent = getIntent();
        editUser.setText(intent.getStringExtra("Username"));
        editPass.setText(intent.getStringExtra("Password"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}