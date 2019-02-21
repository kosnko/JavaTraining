package com.luxoft.jva001p1.demos;

public class Bear {

    int weight; // 150 кг - 1000 кг, grizzly ~700, brown bear ~ 200 - 300 кг
    int age; // growth till 10-11 year. Live — 20-30 years
    String name;
    Address address;
    boolean isHungry = true;
    Fish[] fishes = new Fish[10];
    int fishNum = 0;

    // red salmon, hunchback salmon, chum salmon, bulltrout, Arctic cisco
    void eatChosenFish(String fishSpecies)
    {
        int quantity = 0;
        double weight = 0;
        for (int i = 0; i < fishNum; i++) {
            if (fishes[i].species.equals(fishSpecies)){
                Fish eatenFish = fishes[i];
                if (i < fishNum - 1) {
                    fishes[i] = fishes[fishNum-1];
                    fishes[fishNum-1] = null;
                } else {
                    fishes[i] = null;
                }
                fishNum--;
                quantity++;
                weight = weight + eatenFish.weight;
                isHungry = false;
                System.out.println(name + " has eaten "+fishSpecies+", weight "+eatenFish.weight);
            }
        }
        if (quantity !=0){
            System.out.println(name + " has eaten "+quantity+" "+fishSpecies);
        }else{
            System.out.println(name + " has NO "+fishSpecies);
        }
        if (weight == 0){
            System.out.println(name+" has nothing to eat!");
        }else if(weight > 10 && weight <=25){
            System.out.println(name+" has eaten very well!");
        }else{
            System.out.println(name+" has overeaten..,");
        }
        //if (isHungry) System.out.println(name+" have nothing to eat!");
    }

    void bearCaughtFish(Fish fish)
    {
        if (fish.weight <= 0){
            System.out.println("What the hell with this fish!");
            return;
        }
        fishes[fishNum++] = fish;
        if (fish.weight < 3){
            System.out.println(name+" caught "+fish.species);
        } else if (fish.weight >= 3 && fish.weight < 5){
            System.out.println(name+" is very glad to catch "+fish.species);
        } else {
            System.out.println(name+" is stunned by "+fish.species+". How big is that!");
        }
    }

    void eatUpAllFish()
    {
        double weight = 0;
        for (int i = 0; i < fishNum; i++) {
            weight = weight + fishes[i].weight;
            fishes[i] = null;
        }
        System.out.println(name+" has eaten up "+weight+"kg of fish!");
    }

    void chagneCityBearLives(Bear bear, String city)
    {
        bear.address.city = city;
    }



}
