package com.drishti.vendingmachine.drinks;

import com.drishti.vendingmachine.drinks.recipe.Container;
import com.drishti.vendingmachine.drinks.recipe.Drink;
import com.drishti.vendingmachine.drinks.recipe.DrinkRecipe;
import com.drishti.vendingmachine.drinks.recipe.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Chinthaka @chikaslocalhost
 * Package : com.drishti.vendingmachine.drinks
 * Date Time : 10/3/18 - 10:21 AM
 */
public class DrinkManager {

    /**
     * Searching pre defined recipes to proceed with drink making in vending machine.
     * @return
     */
    public DrinkRecipe searchRecipeForDrink(Drink drink){
        DrinkRecipe drinkRecipe = null;
        switch (drink){
            case TEA:
                drinkRecipe = new DrinkRecipe(Drink.TEA, addIngredients(Drink.TEA));
                break;
            case TOMATO_SOUP:
                drinkRecipe = new DrinkRecipe(Drink.TOMATO_SOUP, addIngredients(Drink.TOMATO_SOUP));
                break;
            case COFFEE:
                drinkRecipe = new DrinkRecipe(Drink.COFFEE, addIngredients(Drink.COFFEE));
                break;
        }
        return drinkRecipe;
    }

    /*Define Ingredients for selected Drink*/
    private List<Ingredient> addIngredients(Drink drink) {
        List<Ingredient> ingredients = new ArrayList<>();
        switch (drink){
            case TEA:
                ingredients.add(Container.addTeaPowder());
                ingredients.add(Container.addSugar());
                ingredients.add(Container.addMilk());
                ingredients.add(Container.addWater());
                break;
            case COFFEE:
                ingredients.add(Container.addCofeePowder());
                ingredients.add(Container.addSugar());
                ingredients.add(Container.addMilk());
                ingredients.add(Container.addWater());
                break;
            case TOMATO_SOUP:
                ingredients.add(Container.addSoupMix());
                ingredients.add(Container.addWater());
                break;
        }
        return ingredients;
    }

}
