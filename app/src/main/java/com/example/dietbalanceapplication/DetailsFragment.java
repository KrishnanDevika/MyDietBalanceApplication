package com.example.dietbalanceapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dietbalanceapplication.SettingsList.CustomSettingsListAdapter;
import com.example.dietbalanceapplication.SettingsList.SettingOptions;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SharedPreferences sharedPreferences;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ListView detailsList = view.findViewById(R.id.detailsList);

        ArrayList<SettingOptions> settingOptions = new ArrayList<>();
        String weight = UserProfileFragment.getWeight ;
        String height = UserProfileFragment.getHeight;
        String gender =  UserProfileFragment.gen;
        String age = UserProfileFragment.yourAge;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String heightUnit =sharedPreferences.getString("heightUnits", "cm");
        String weightUnit = sharedPreferences.getString("weightUnits", "kg");
        String hUnit;
        String wUnit;

        if (weight != null) {
            if(heightUnit.equalsIgnoreCase("inches")){
                hUnit = "inches";
            }else{
                hUnit = "cm";
            }

            if(weightUnit.equalsIgnoreCase("lbs")){
                wUnit = "lbs";
            }else{
                wUnit = "kg";
            }
            settingOptions.add(new SettingOptions(R.drawable.weight, "Weight", weight+ wUnit));
            settingOptions.add(new SettingOptions(R.drawable.height, "Height", height + hUnit ));
            settingOptions.add(new SettingOptions(R.drawable.gender, "Gender", gender));
            settingOptions.add(new SettingOptions(R.drawable.ic_baseline_cake_24, "Your age", age + " years"));
        }else{
            settingOptions.add(new SettingOptions(R.drawable.weight, "Weight", ""));
            settingOptions.add(new SettingOptions(R.drawable.height, "Height", "" ));
            settingOptions.add(new SettingOptions(R.drawable.gender, "Gender", ""));
            settingOptions.add(new SettingOptions(R.drawable.ic_baseline_cake_24, "Your age", ""));
            Toast.makeText(getContext(), "Please fill the User Profile section", Toast.LENGTH_SHORT).show();
        }

        detailsList.setAdapter(new CustomSettingsListAdapter(getContext(), settingOptions));
        return view;
    }
}