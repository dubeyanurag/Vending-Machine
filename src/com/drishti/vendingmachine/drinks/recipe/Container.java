package com.drishti.vendingmachine.drinks.recipe;

/**
 * Developed by Chinthaka @chikaslocalhost
 * Package : com.drishti.vendingmachine.drinks.recipe
 * Date Time : 10/3/18 - 10:37 AM
 */
public class Container {

    /*Adding Tea Powder For Recipe*/
    public static Ingredient addTeaPowder(){
        return new Ingredient("Tea power");
    }
    /*Adding Sugar For Recipe*/
    public static Ingredient addSugar(){
        return new Ingredient("Sugar");
    }
    /*Adding Milk For Recipe*/
    public static Ingredient addMilk(){
        return new Ingredient("Milk");
    }
    /*Adding Water For Recipe*/
    public static Ingredient addWater(){
        return new Ingredient("Water");
    }
    /*Adding Coffee Powder For Recipe*/
    public static Ingredient addCofeePowder(){
        return new Ingredient("Coffee Powder");
    }
    /*Adding Soup Mix For Recipe*/
    public static Ingredient addSoupMix(){
        return new Ingredient("Soup Mix");
    }

}
