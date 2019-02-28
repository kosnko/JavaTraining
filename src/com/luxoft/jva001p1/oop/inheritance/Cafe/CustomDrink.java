package com.luxoft.jva001p1.oop.inheritance.Cafe;

import java.util.Arrays;

public class CustomDrink extends Drink {
    private Ingredient[] ingredients;
    private String[] ingredientParts;

    public CustomDrink(Ingredient[] ingredients, String[] ingredientParts, String customName) {
        this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
        this.ingredientParts = Arrays.copyOf(ingredientParts, ingredientParts.length);
        setName(generateName(customName));
    }

    private String generateName(String customName) {
        String name = new String("Custom_"+customName+'\n');
        for (int i = 0; i < ingredients.length; i++) {
            name = name + " - "+ingredientParts[i]+" "+ingredients[i].getName()+'\n';
        }
        return name = new String(name.toCharArray(), 0, name.length()-1);
    }

    @Override
    public double getPrice(){
        double price = 0;
        for (int i = 0; i < ingredients.length; i++) {
            price += Cafe.getNumberOfPart(ingredientParts[i])*ingredients[i].getPrice();
        }
        return price;
    }

}
