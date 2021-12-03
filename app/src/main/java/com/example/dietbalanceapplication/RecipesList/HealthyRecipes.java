package com.example.dietbalanceapplication.RecipesList;

/**
 * Class contains list of items to be displayed in list view
 */
public class HealthyRecipes {
    private int recipeImage;
    private String recipeName;


    /**
     * Constructor for initialising properties
     * @param recipeImage
     * @param recipeName
     */
    public HealthyRecipes(int recipeImage, String recipeName) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    /**
     * To Get Recipe Name
     * @return recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Set recipeName
     * @param recipeName
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * to get recipeImage
     * @return recipeImage
     */
    public int getRecipeImage() {
        return recipeImage;
    }

    /**
     * setRecipe Image
     * @param recipeImage
     */
    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }
}
