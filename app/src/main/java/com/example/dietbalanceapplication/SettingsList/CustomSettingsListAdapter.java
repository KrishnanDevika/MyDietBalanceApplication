package com.example.dietbalanceapplication.SettingsList;

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

public class CustomSettingsListAdapter extends ArrayAdapter<SettingOptions> {
    public CustomSettingsListAdapter(@NonNull Context context, ArrayList<SettingOptions> items) {
        super(context, 0, items);
    }

    /**
     * This method will place all the items to the list view
     * @param position
     * @param convertView
     * @param parent
     * @return view
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_settings_list, parent, false);

        }

        ImageView settingImage = convertView.findViewById(R.id.settingImage);
        settingImage.setImageResource(getItem(position).getSettingIcon());

        TextView settingName = convertView.findViewById(R.id.settingName);
        settingName.setText(getItem(position).getSettingItems());

        TextView settingDesc = convertView.findViewById(R.id.settingDesc);
        settingDesc.setText(getItem(position).getSettingsDesc());

        return convertView;
    }
}
