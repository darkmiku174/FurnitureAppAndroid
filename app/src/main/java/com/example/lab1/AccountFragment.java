package com.example.lab1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AccountFragment extends Fragment {
    EditText editName, editEmail, editPass, editUser;
    RadioButton rdbGender;
    Toolbar toolbar;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

   
        return inflater.inflate(R.layout.activity_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editName = view.findViewById(R.id.editTextName);
        editEmail = view.findViewById(R.id.editTextEmail);
        editUser = view.findViewById(R.id.editTextUserName);
        editPass = view.findViewById(R.id.editTextPassword);
        rdbGender = view.findViewById(R.id.radioButtonMale);
    }
}
