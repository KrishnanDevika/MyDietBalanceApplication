package com.example.dietbalanceapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SharedPreferences sharedPreferences;

    public static String getWeight;
    public static String getHeight;
    public static String gen;
    public static String yourAge;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserProfileFragment newInstance(String param1, String param2) {
        UserProfileFragment fragment = new UserProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        Spinner genderSpinner = view.findViewById(R.id.genderSelector);
        EditText ageText = view.findViewById(R.id.agetEditTextNumber);
        EditText weightText = view.findViewById(R.id.weightEditText);
        EditText heightText = view.findViewById(R.id.heightEditText);
        ArrayList<String> genders = new ArrayList<>();
        genders.add("");
        genders.add("Male");
        genders.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner, genders);
        dataAdapter.setDropDownViewResource(R.layout.custom_simple_spinner_dropdown_item);
        genderSpinner.setBackgroundColor(getResources().getColor(R.color.lime_200));
        genderSpinner.setAdapter(dataAdapter);
        TextView resultText = view.findViewById(R.id.feedbackText);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String heightUnit =sharedPreferences.getString("heightUnits", "cm");
        String weightUnit = sharedPreferences.getString("weightUnits", "kg");
        if(heightUnit.equalsIgnoreCase("cm")) {
            heightText.setHint("Height in cm");
        }
        if(heightUnit.equalsIgnoreCase("inches")){
            heightText.setHint("Height in inches");
        }

        if(weightUnit.equalsIgnoreCase("kg")){
           weightText.setHint("Weight in kg");
        }

        if(weightUnit.equalsIgnoreCase("lbs")){
            weightText.setHint("Weight in pounds");
        }

            Button submitButton = view.findViewById(R.id.submitButton);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        double bmi = 0;
                        double weight = Double.parseDouble(weightText.getText().toString());
                        double height = Double.parseDouble(heightText.getText().toString());
                        if(heightUnit.equalsIgnoreCase("cm")) {
                             height = height;
                        }
                        if(heightUnit.equalsIgnoreCase("inches")){
                            height = height * 2.54;
                        }

                        if(weightUnit.equalsIgnoreCase("kg")){
                           weight = weight;
                        }

                        if(weightUnit.equalsIgnoreCase("lbs")){
                            weight = weight / 2.205;
                        }
                        bmi = Calculator.bmiCalculation(weight, height);
                        resultText.setVisibility(View.VISIBLE);
                        resultText.setText(new StringBuilder().append("Based on your Height and Weight your Body Mass Index(BMI) is ").append(String.format("%.2f", bmi)).append("\n").append("Category : ").append("'").append(Calculator.feedback.toUpperCase()).append("'").toString());
                        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.image_animation);
                        resultText.startAnimation(animation);

                        getWeight = weightText.getText().toString();
                        getHeight = heightText.getText().toString();
                        gen = genderSpinner.getSelectedItem().toString();
                        yourAge = ageText.getText().toString();


                    } catch (Exception ex) {
                        Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                    }
                }
            });





        return view;
    }
}