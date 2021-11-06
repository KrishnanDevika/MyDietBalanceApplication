package com.example.dietbalanceapplication.ContactsList;

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

public class CustomContactListAdapter extends ArrayAdapter<Contacts> {

    public CustomContactListAdapter(@NonNull Context context, ArrayList<Contacts> listItems) {
        super(context,0, listItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list_view, parent, false);

        }

        ImageView contactImage = convertView.findViewById(R.id.contact_icon);
        contactImage.setImageResource(getItem(position).getContactIcon());

        TextView contactMode = convertView.findViewById(R.id.contact_mode);
        contactMode.setText(getItem(position).getContactMode());

        TextView contactDesc = convertView.findViewById(R.id.contact_desc);
        contactDesc.setText(getItem(position).getContactDesc());

        return convertView;
    }
}
