package com.example.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    EditText editName, editEmail, editPass, editUser;
    RadioButton rdbGender;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        sharedPreferences = getSharedPreferences("dataAccount", MODE_PRIVATE);
        editName = findViewById(R.id.editTextName);
        editEmail = findViewById(R.id.editTextEmail);
        editUser = findViewById(R.id.editTextUserName);
        editPass = findViewById(R.id.editTextPassword);
        rdbGender = findViewById(R.id.radioButtonMale);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", editName.getText().toString().trim());
            editor.putString("email", editEmail.getText().toString().trim());
            editor.putString("user", editUser.getText().toString().trim());
            editor.putString("pass", editPass.getText().toString().trim());
            editor.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}