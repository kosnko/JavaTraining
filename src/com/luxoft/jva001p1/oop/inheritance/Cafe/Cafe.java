package com.luxoft.jva001p1.oop.inheritance.Cafe;

import java.util.Arrays;

public class Cafe {

    private Ingredient[] ingredients;
    private Drink[] drinks;

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Ingredient[] ingredients = {
                new Ingredient("espresso", 60),
                new Ingredient("coffee", 40),
                new Ingredient("steamed milk", 30),
                new Ingredient("hot milk", 15),
                new Ingredient("hot water", 5)};
        cafe.setIngredients(ingredients);
        Drink[] drinks = {
                new Drink("Espresso (1/3 espresso)", 22),
                new Drink("Tripplo", 60),
                new Drink("Black coffee", 40)};
        cafe.setDrinks(drinks);

        Drink drink1 = new Drink("Americano (1/3 espresso, 2/3 hot water)", 25);
        cafe.addNewDrink(drink1);
        ingredients = new Ingredient[]{
                cafe.getIngredients()[0],
                cafe.getIngredients()[2]};
        String[] parts = {"1/4", "3/4"};
        CustomDrink drink2 = cafe.createCustomDrink(ingredients, parts,"Galao");
        ingredients = new Ingredient[]{
                cafe.getIngredients()[1],
                cafe.getIngredients()[2]};
        parts = new String[]{"2/3", "1/3"};
        CustomDrink drink3 = cafe.createCustomDrink(ingredients, parts,"Latte");

        Order order = new Order();
        order.addDrink(drink1, 1, 1);
        order.addDrink(cafe.drinks[0], 1.5, 1);
        order.addDrink(cafe.drinks[1], 1, 1);
        order.addDrink(cafe.drinks[2], 1, 2);
        order.addDrink(drink2, 1, 2);
        order.addDrink(drink3, 1.75, 1);
        cafe.printReceipt(order);
    }

    public void printReceipt(Order order){
        System.out.println("    Curstomer order.");
        double totalPrice = 0;
        for (int i = 0; i < order.getDrinks().length; i++) {
            String name = order.getDrinks()[i].getName();
            double por = order.getPortions()[i];
            int num = order.getNums()[i];
            double price = por*num*order.getDrinks()[i].getPrice();
            System.out.println(name+"\n -- portion: "+por+", num: "+num+", price: "+price);
            totalPrice += price;
        }
        System.out.println("TOTAL PRICE: "+totalPrice);
    }

    public void addNewDrink(Drink drink){
        drinks = Arrays.copyOf(drinks, drinks.length+1);
        drinks[drinks.length-1] = drink;
    }

    public void addNewIngredient(Ingredient ingredient){
        ingredients = Arrays.copyOf(ingredients, ingredients.length+1);
        ingredients[ingredients.length-1] = ingredient;
    }

    public static double getNumberOfPart(String part){
        double partNum = 0;
        int divInd = part.indexOf('/');
        if (divInd == 0 || divInd == part.length()-1) {
            partNum = -1;
            System.out.println("Ingredient part ("+part+") is specified incorrectly!");
        }else if (divInd == -1) {
            partNum += Double.parseDouble(part);
        }else {
            partNum += Double.parseDouble(part.substring(0,divInd)) / Double.parseDouble(part.substring(divInd+1));
        }
        return partNum;
    }

    public CustomDrink createCustomDrink(Ingredient[] ingredients, String[] parts, String customName){
        double partsSum = 0;
        for (String part : parts) {
            double partNum = getNumberOfPart(part);
            if (partNum == -1){
                System.out.println(customName+": Ingredient part ("+part+") is specified incorrectly!");
            }else{
                partsSum += partNum;
            }
        }
        if (partsSum > 1) {
            System.out.println(customName + ": Ingredient parts sum is more than 1!");
            return null;
        }else {
            CustomDrink drink = new CustomDrink(ingredients, parts, customName);
            return drink;
        }
    }

    public Cafe() {
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(Drink[] drinks) {
        this.drinks = Arrays.copyOf(drinks, drinks.length);
    }
}
