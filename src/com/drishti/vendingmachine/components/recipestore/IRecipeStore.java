package com.drishti.vendingmachine.components.recipestore;

import com.drishti.vendingmachine.components.drinksmanager.IDrink;

public interface IRecipeStore {
	public IRecipe getRecipe(IDrink drink) throws RecipeNotFoundException;
}
