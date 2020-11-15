package com.example.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FurnitureAdapter extends ArrayAdapter<Furniture> {

    Context context;
    ArrayList<Furniture> arrayList;


    public FurnitureAdapter(@NonNull Context context, @NonNull ArrayList<Furniture> objects) {
        super(context, 0, objects);
        this.context = context;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.layout_item_list, parent, false);

        Furniture furniture = arrayList.get(position);

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewDescription = convertView.findViewById(R.id.textViewDescription);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        textViewName.setText(furniture.getName());
        textViewDescription.setText(furniture.getDescription());
        imageView.setImageBitmap(Furniture.convertStringToBitmapFromAccess(getContext(), furniture.getImage()));


        return convertView;
    }
}
