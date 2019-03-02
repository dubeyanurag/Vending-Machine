package com.drishti.vendingmachine.components.drinksmanager;

public enum DrinksNameEnum {
	TEA(0),COFFEE(1),SOUP(2);
	int ordinal = 0;

	DrinksNameEnum(int ord) {
        this.ordinal = ord;
    }

    public static DrinksNameEnum get(int ord) throws DispatchFailedException {
    	if(ord<=0 || ord>DrinksNameEnum.values().length){
    		throw new DispatchFailedException("Drink Not found");
    	}
        return DrinksNameEnum.values()[ord-1];
    }
}
