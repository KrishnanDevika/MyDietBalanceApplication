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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        Button bmi = view.findViewById(R.id.bmiButton);
        Button calorieCalc = view.findViewById(R.id.calorieButton);
        Button pregnancyCalorie = view.findViewById(R.id.pregnancyButton);
        Button feedingButton = view.findViewById(R.id.feedingButton);
        Button weightButton = view.findViewById(R.id.weightButton);

        TextView ageText = view.findViewById(R.id.agetextId);
        TextView heightText = view.findViewById(R.id.heightText);
        TextView weightText = view.findViewById(R.id.weightText);
        TextView genderText = view.findViewById(R.id.genderText);
        TextView exerciseText = view.findViewById(R.id.exerciseText);
        TextView result = view.findViewById(R.id.resultText);

        EditText age = view.findViewById(R.id.age);
        EditText heightValue = view.findViewById(R.id.height);
        EditText weightValue = view.findViewById(R.id.weight);
        Spinner gender = view.findViewById(R.id.gender);
        Spinner exercise = view.findViewById(R.id.exercise);

        Button submitButton = view.findViewById(R.id.submit);

        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner, genders);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setBackgroundColor(getResources().getColor(R.color.lime_200));
        gender.setAdapter(dataAdapter);

        ArrayList<String> exercises = new ArrayList<>();
        exercises.add("Little or no exercises");
        exercises.add("Light exercise or sports (1 -3) days/week");
        exercises.add("moderate exercise or sports (3 - 5) days/week");
        exercises.add("hard exercise or sports (6 - 7) days/week");
        exercises.add("very hard exercise or sports/physical job");

        ArrayAdapter<String> data = new ArrayAdapter<>(getContext(), R.layout.custom_spinner, exercises);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise.setBackgroundColor(getResources().getColor(R.color.lime_200));
        exercise.setAdapter(data);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageText.setVisibility(View.GONE);
                age.setVisibility(View.GONE);
                heightValue.setVisibility(View.VISIBLE);
                heightText.setVisibility(View.VISIBLE);
                weightValue.setVisibility(View.VISIBLE);
                weightText.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                genderText.setVisibility(View.GONE);
                gender.setVisibility(View.GONE);
                exerciseText.setVisibility(View.GONE);
                exercise.setVisibility(View.GONE);
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            double weight = Double.parseDouble(weightValue.getText().toString());
                            double height = Double.parseDouble(heightValue.getText().toString());
                            double bmi = Calculator.bmiCalculation(weight, height);
                            result.setVisibility(View.VISIBLE);
                            result.setText("BMI : " + String.format("%.2f", bmi) + "\n You are " + "'" +Calculator.feedback + "'");
                        }catch (Exception e){
                            Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        calorieCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(View.INVISIBLE);
                ageText.setVisibility(View.VISIBLE);
                age.setVisibility(View.VISIBLE);
                heightValue.setVisibility(View.VISIBLE);
                heightText.setVisibility(View.VISIBLE);
                weightValue.setVisibility(View.VISIBLE);
                weightText.setVisibility(View.VISIBLE);
                genderText.setVisibility(View.VISIBLE);
                gender.setVisibility(View.VISIBLE);
                exerciseText.setVisibility(View.VISIBLE);
                exercise.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            int enteredAge = Integer.parseInt(age.getText().toString());
                            double weight = Double.parseDouble(weightValue.getText().toString());
                            double height = Double.parseDouble(heightValue.getText().toString());
                            String gen = gender.getSelectedItem().toString();
                            String exerciseLevel = exercise.getSelectedItem().toString();
                            double caloriesNeeded = Calculator.calorieCalculation(gen, enteredAge, weight, height,exerciseLevel);
                            result.setVisibility(View.VISIBLE);
                            result.setText(" The total number of calories you need in order to maintain your current weight is : " + Math.round(caloriesNeeded) + "cal");
                        }catch (Exception e){
                            Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        pregnancyCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(View.INVISIBLE);
                ageText.setVisibility(View.VISIBLE);
                age.setVisibility(View.VISIBLE);
                heightValue.setVisibility(View.VISIBLE);
                heightText.setVisibility(View.VISIBLE);
                weightValue.setVisibility(View.VISIBLE);
                weightText.setVisibility(View.VISIBLE);
                exerciseText.setVisibility(View.VISIBLE);
                exercise.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                genderText.setVisibility(View.GONE);
                gender.setVisibility(View.GONE);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            int enteredAge = Integer.parseInt(age.getText().toString());
                            double weight = Double.parseDouble(weightValue.getText().toString());
                            double height = Double.parseDouble(heightValue.getText().toString());
                            String exerciseLevel = exercise.getSelectedItem().toString();
                            double caloriesNeeded = Calculator.calorieCalculation("Female", enteredAge, weight, height,exerciseLevel);
                            result.setVisibility(View.VISIBLE);
                            result.setText(" First Trimester : " + (Math.round(caloriesNeeded) + 85) +"cal\n"+
                                            " Second Trimester : " + (Math.round(caloriesNeeded) + 285) +"cal\n" +
                                            " Third Trimester : " + (Math.round(caloriesNeeded) + 475+"cal"));

                        }catch (Exception e){
                            Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        feedingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageText.setVisibility(View.VISIBLE);
                age.setVisibility(View.VISIBLE);
                heightValue.setVisibility(View.VISIBLE);
                heightText.setVisibility(View.VISIBLE);
                weightValue.setVisibility(View.VISIBLE);
                weightText.setVisibility(View.VISIBLE);
                exerciseText.setVisibility(View.VISIBLE);
                exercise.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                genderText.setVisibility(View.GONE);
                gender.setVisibility(View.GONE);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            int enteredAge = Integer.parseInt(age.getText().toString());
                            double weight = Double.parseDouble(weightValue.getText().toString());
                            double height = Double.parseDouble(heightValue.getText().toString());
                            String exerciseLevel = exercise.getSelectedItem().toString();
                            double caloriesNeeded = Calculator.calorieCalculation("Female", enteredAge, weight, height,exerciseLevel);
                            result.setVisibility(View.VISIBLE);
                            result.setText(" Daily you need  : " + (Math.round(caloriesNeeded) + 400) +"cal");
                        }catch (Exception e){
                            Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heightValue.setVisibility(View.VISIBLE);
                heightText.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                ageText.setVisibility(View.GONE);
                age.setVisibility(View.GONE);
                weightValue.setVisibility(View.GONE);
                weightText.setVisibility(View.GONE);
                genderText.setVisibility(View.GONE);
                gender.setVisibility(View.GONE);
                exerciseText.setVisibility(View.GONE);
                exercise.setVisibility(View.GONE);
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            double height = Double.parseDouble(heightValue.getText().toString());
                            double heightInMeters = height / 100;
                            double weightFrom, weightTo;
                            weightFrom = 18.5 * (heightInMeters * heightInMeters);
                            weightTo = 25  * (heightInMeters * heightInMeters);
                            result.setVisibility(View.VISIBLE);
                            result.setText(" Your ideal Weight should be between  "+ Math.round(weightFrom) +"Kg - " +Math.round(weightTo) +"Kg");
                        }catch (Exception e){
                            Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        return view;
    }
}