package com.luxoft.jva001p1.oop.inheritance.Cafe;

import java.util.Arrays;

public class Order {
    private Drink[] drinks = new Drink[0];
    private double[] portions = new double[0];
    private int[] nums = new int[0];

    public void addDrink(Drink drink, double portion, int num){
        drinks = Arrays.copyOf(drinks,drinks.length+1);
        drinks[drinks.length-1] = drink;
        portions = Arrays.copyOf(portions,portions.length+1);
        portions[portions.length-1] = portion;
        nums = Arrays.copyOf(nums,nums.length+1);
        nums[nums.length-1] = num;

    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public double[] getPortions() {
        return portions;
    }

    public int[] getNums() {
        return nums;
    }
}
