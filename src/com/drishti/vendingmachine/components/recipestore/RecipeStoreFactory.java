package com.drishti.vendingmachine.components.recipestore;

import java.util.HashMap;
import java.util.Map;

import com.drishti.vendingmachine.IContext;
import com.drishti.vendingmachine.components.BaseVendingMachineComponent;
import com.drishti.vendingmachine.components.IVendingMachineComponent;
import com.drishti.vendingmachine.components.InvalidComponentStateException;
import com.drishti.vendingmachine.components.drinksmanager.IDrink;

public class RecipeStoreFactory {
	public static IVendingMachineComponent newInstance(IContext context) {
		return new RecipeStore(context);
	}

	static class RecipeStore extends BaseVendingMachineComponent implements IRecipeStore {
		private Map<IDrink, IRecipe> drinkVsRecipe;

		private RecipeStore(IContext context) {
			super(context);
			drinkVsRecipe = new HashMap<IDrink, IRecipe>();
		}

		@Override
		public IRecipe getRecipe(IDrink drink) throws RecipeNotFoundException {
			if (!drinkVsRecipe.containsKey(drink)) {
				throw new RecipeNotFoundException("Recipe Not found in store for " + drink.getDrinkName());
			}
			return drinkVsRecipe.get(drink);
		}

	}
}
