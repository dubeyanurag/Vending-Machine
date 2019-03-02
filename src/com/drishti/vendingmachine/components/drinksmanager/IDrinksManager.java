package com.drishti.vendingmachine.components.drinksmanager;

public interface IDrinksManager {
	public void dispatchDrink(DrinksNameEnum drink) throws DispatchFailedException;
}
