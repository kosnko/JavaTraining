package com.luxoft.jva001p1.demos;

//import com.luxoft.jva001p1.oop.inheritance.p7data.Flyer;

import java.util.Arrays;

public class Demo
{
    public static void main(String[] args)
    {
        //System.out.println(Flyer.WINGS);

        Address addresss = new Address();
        addresss.country = "Ukraine";
        addresss.city = "Kiev";

        Bear bear1 = new Bear();
        bear1.age = 10;
        bear1.name = "Brown bear";
        bear1.address = addresss;
        bear1.weight = 200;

        String[] fishSpecies = {"red salmon", "hunchback salmon", "chum salmon", "bulltrout", "Arctic cisco"};
        //// catching ///////////
        Fish fish1 = new Fish();
        fish1.species = fishSpecies[3];//"bulltrout";
        fish1.weight = 24;
        bear1.bearCaughtFish(fish1);
        Fish fish2 = new Fish();
        fish2.species = fishSpecies[3];//"bulltrout";
        fish2.weight = 3;
        bear1.bearCaughtFish(fish2);
        Fish fish3 = new Fish();
        fish3.species = fishSpecies[4];//"Arctic cisco";
        fish3.weight = 1;
        bear1.bearCaughtFish(fish3);
        Fish fish4 = new Fish();
        fish4.species = fishSpecies[0];//"red salmon";
        fish4.weight = 1.5;
        bear1.bearCaughtFish(fish4);
        Fish fish5 = new Fish();
        fish5.species = fishSpecies[2];//"chum salmon ";
        fish5.weight = 4.5;
        bear1.bearCaughtFish(fish5);

//        bear1.eatChosenFish(fishSpecies[3]);
//        System.out.println(Arrays.deepToString(bear1.fishes));
//
//        bear1.eatChosenFish(fishSpecies[1]);

        System.out.println(Arrays.deepToString(bear1.fishes));
        bear1.eatUpAllFish();
        System.out.println(Arrays.deepToString(bear1.fishes));













//        Bear bear2 = new Bear();
//        bear2.address = new Address();
//        bear2.age = 6;
//        bear2.name = "White bear";
//        bear2.address.country = "Russia";
//        bear2.address.city = "Moscow";
//        bear2.weight = 80;
//
//        Bear bear3 = new Bear();
//        bear3.address = new Address();
//        bear3.age = 4;
//        bear3.name = "Koala";
//        bear3.address.country = "Australia";
//        bear3.address.city = "Melbourne";// Melbourne , Canberra
//        bear3.weight = 60;

//        System.out.println(bear3.name+" lives in "+ bear3.address.city);
//        bear3.chagneCityBearLives(bear3, "Canberra");
//        System.out.println(bear3.name+" lives in "+ bear3.address.city);
//
//        bear2.feed();
//
//        Bear[] bears = {bear1,bear2,bear3};
//        System.out.println("Hugry bears:");
//        for (Bear bear: bears) {
//            if (bear.isHungry) System.out.println(" - "+bear.name);
//        }

    }

}
