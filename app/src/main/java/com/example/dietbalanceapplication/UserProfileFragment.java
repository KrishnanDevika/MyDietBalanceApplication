package com.example.dietbalanceapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
        EditText weightText = view.findViewById(R.id.weightEditText);
        EditText heightText = view.findViewById(R.id.heightEditText);
        ArrayList<String> genders = new ArrayList<>();
        genders.add("");
        genders.add("Male");
        genders.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner, genders);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setBackgroundColor(getResources().getColor(R.color.lime_200));
        genderSpinner.setAdapter(dataAdapter);
        TextView resultText = view.findViewById(R.id.feedbackText);
        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setVisibility(View.VISIBLE);
                double weight = Double.parseDouble(weightText.getText().toString());
                double height = Double.parseDouble(heightText.getText().toString());
                double heightInMeters = height / 100;
                double bmi;
                bmi = weight / (heightInMeters *heightInMeters);

                String feedback;

                if (bmi < 18.5){
                    feedback = "UnderWeight";
                }else if(bmi >= 18.5 && bmi < 25){
                    feedback = "Healthy Weight";
                }else if(bmi >= 25 && bmi < 30){
                    feedback = "OverWeight";
                }else{
                    feedback = "Obesity";
                }

                resultText.setText("Based on your Height and Weight your Body Mass Index(BMI) is "+ String.format("%.2f",bmi) +"\n"+
                        "You are in the Category of \n"+
                        "'" +feedback.toUpperCase()+ "'");

            }
        });



        return view;
    }
}