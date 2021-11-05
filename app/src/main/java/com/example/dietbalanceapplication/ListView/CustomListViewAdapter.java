package com.example.dietbalanceapplication.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dietbalanceapplication.R;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<HealthyRecipes> {
    public CustomListViewAdapter(@NonNull Context context, ArrayList<HealthyRecipes> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);

        }

        ImageView recipeImage = convertView.findViewById(R.id.recipeImage);
        recipeImage.setImageResource(getItem(position).getRecipeImage());

        TextView recipeName = convertView.findViewById(R.id.recipeName);
        recipeName.setText(getItem(position).getRecipeName());

        return convertView;
    }
}