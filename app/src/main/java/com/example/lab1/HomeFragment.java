package com.example.lab1;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    Utils utils;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        utils = new Utils(getContext());
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);
        arrayList = utils.getMockData();
        furnitureAdapter = new FurnitureAdapter(getContext(), arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long
                    l) {
                if (Contains(Utils.furnitureHistory, arrayList.get(i).getName()) == true) {
                    Utils.furnitureHistory.add(arrayList.get(i));
                    Toast.makeText(getContext(), i + "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("furniture", arrayList.get(i));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        utils.WriteToFileInternal(arrayList);
    }

    public boolean Contains(ArrayList<Furniture> list, String name) {
        for (Furniture item : list) {
            if (item.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}

