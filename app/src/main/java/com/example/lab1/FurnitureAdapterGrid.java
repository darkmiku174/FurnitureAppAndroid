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

public class FurnitureAdapterGrid extends ArrayAdapter<Categories> {
    Context context;
    ArrayList<Categories> arrayList;


    public FurnitureAdapterGrid(@NonNull Context context, @NonNull ArrayList<Categories> objects) {
        super(context, 0, objects);
        this.context = context;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.layout_item_grid, parent, false);

        Categories categories = arrayList.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewCatagories);
        TextView textView = convertView.findViewById(R.id.textViewCatagories);

        imageView.setImageBitmap(Categories.convertStringToBitmapFromAccess(getContext(), categories.getImage()));
        textView.setText(categories.getName());

        return convertView;
    }
}
