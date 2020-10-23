package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText editEmail, editUser, editPass, editConfPass;
    Button btnSign, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editEmail = findViewById(R.id.editTextEmail);
        editUser = findViewById(R.id.editTextUserName);
        editPass = findViewById(R.id.editTextPassword);
        editConfPass = findViewById(R.id.editTextConfirmPassword);
        btnSign = findViewById(R.id.buttonSignIn);
        btnCancel = findViewById(R.id.buttonCancel);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isValid(editEmail.getText().toString())) {
                    editEmail.setError("Invalid Email Address");
                }
                if (editUser.getText().toString().isEmpty()) {
                    editUser.setError("Username cannot be null ");
                    return;
                }
                if (editPass.getText().toString().isEmpty()) {
                    editPass.setError("Password required");
                    return;
                }
                if (editConfPass.getText().toString().isEmpty()) {
                    editPass.setError("Password required");
                    return;
                }

                if (editPass.getText().toString().equals(editConfPass.getText().toString())) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("Username", editUser.getText().toString());
                    intent.putExtra("Password", editPass.getText().toString());
                    setResult(101, intent);
                    finish();
                } else {
                    editPass.setError("Password and confirm password does not match");
                    editConfPass.setText("");
                    return;
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}