package com.drishti.vendingmachine.drinks.recipe;

import java.util.List;

/**
 * Developed by Chinthaka @chikaslocalhost
 * Package : com.drishti.vendingmachine.drinks.recipe
 * Date Time : 10/3/18 - 10:22 AM
 */
public class DrinkRecipe {

    /*Drink Name*/
    private Drink name;

    /*Ingredients*/
    private List<Ingredient> ingredients;

    public DrinkRecipe(Drink name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Drink getName() {
        return name;
    }

    public void setName(Drink name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "DrinkRecipe{" +
                "name=" + name +
                ", ingredients=" + ingredients +
                '}';
    }
}
