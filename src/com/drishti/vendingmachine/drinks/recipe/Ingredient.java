package com.drishti.vendingmachine.drinks.recipe;

/**
 * Developed by Chinthaka @chikaslocalhost
 * Package : com.drishti.vendingmachine.drinks.recipe
 * Date Time : 10/3/18 - 10:23 AM
 */
public class Ingredient {

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                '}';
    }
}
