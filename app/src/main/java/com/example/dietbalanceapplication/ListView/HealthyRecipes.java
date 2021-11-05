package com.example.dietbalanceapplication.ListView;

public class HealthyRecipes {
    private int recipeImage;
    private String recipeName;


    public HealthyRecipes(int recipeImage, String recipeName) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }
}
