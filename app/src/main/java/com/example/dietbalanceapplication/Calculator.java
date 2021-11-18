package com.example.dietbalanceapplication;

public class Calculator {
    public static String feedback;

    public static double bmiCalculation(double weight, double height){
        double bmi;
        double heightInMeters = height / 100;
        bmi = weight / (heightInMeters * heightInMeters);

        if (bmi < 18.5) {
            feedback = "UnderWeight";
        } else if (bmi >= 18.5 && bmi < 25) {
            feedback = "Healthy Weight";
        } else if (bmi >= 25 && bmi < 30) {
            feedback = "OverWeight";
        } else {
            feedback = "Obesity";
        }

        return bmi;

    }
    public static double calorieCalculation(String gen, int enteredAge, double weight, double height, String exerciseLevel){
        double bmr = 0;
        double caloriesNeeded;

        switch (gen){
            case "Male":
                bmr = (10 * weight) + (6.25 * height) - ( 5 * enteredAge) + 5;
                break;
            case "Female":
                bmr = (10 * weight) + (6.25 * height) - ( 5 * enteredAge) - 161;
                break;
        }

        switch (exerciseLevel){
            case "Little or no exercises":
                caloriesNeeded = bmr * 1.2;
                break;
            case "Light exercise or sports (1 -3) days/week":
                caloriesNeeded = bmr * 1.375;
                break;
            case "moderate exercise or sports (3 - 5) days/week":
                caloriesNeeded = bmr * 1.55;
                break;
            case "hard exercise or sports (6 - 7) days/week":
                caloriesNeeded = bmr * 1.725;
                break;
            case "very hard exercise or sports/physical job":
                caloriesNeeded = bmr * 1.9;
                break;
            default:
                caloriesNeeded = 0;
        }
        return caloriesNeeded;

    }

}
