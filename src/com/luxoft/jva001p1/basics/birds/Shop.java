package com.luxoft.jva001p1.basics.birds;

import java.util.Arrays;

public class Shop {

    static int birdTypeMax = 10; //
    static int birdTypeNum = 0; // count of different birds in shop
    static String[] birds = new String[birdTypeMax];
    static double[][] birdAttrs = new double[birdTypeMax][3];

    static int PRICE = 0;
    static int COUNT = 1;
    static int SOLD = 2;

    static void addBirdToStorage(String newBird, double price, int count) {
        int birdIdx = findBirdInStorage(newBird);
        if (birdIdx >= 0) {
            birdAttrs[birdIdx][PRICE] = price; //update
            birdAttrs[birdIdx][COUNT] += count;
        } else {
            if (birdTypeNum == birdTypeMax) {
                increseTypeQuantity();
            }
            birds[birdTypeNum] = newBird;
            if(birdAttrs[birdTypeNum] == null) // Arrays.copyOf returns nulls
            {
                birdAttrs[birdTypeNum] = new double[]{price, count, 0};
            }
            else{
                birdAttrs[birdTypeNum][PRICE] = price;
                birdAttrs[birdTypeNum][COUNT] = count;
            }
            birdTypeNum++;
        }
    }

    static void removeBirdFromStorage(String bird) {
        int birdIdx = findBirdInStorage(bird);
        if (birdIdx >= 0) {
            birds[birdIdx] = birds[birdTypeNum-1];
            birdAttrs[birdIdx][PRICE] = birdAttrs[birdTypeNum-1][PRICE];
            birdAttrs[birdIdx][COUNT] = birdAttrs[birdTypeNum-1][COUNT];
            birdAttrs[birdIdx][SOLD] = birdAttrs[birdTypeNum-1][SOLD];
            birds[birdTypeNum-1] = null;
            birdAttrs[birdTypeNum-1] = new double[]{0,0,0}; // or new double[3]
            birdTypeNum--;
        } else {
            System.out.println("We don't have \"" + bird + "\" in the Storage");
        }
    }

    static void increseTypeQuantity() {
        birdTypeMax = birdTypeMax+5;

        // First method
//        String[] newBirds = new String[birdTypeMax];
//        double[][] newBirdAttrs = new double[birdTypeMax][3];
//        int iter = 0;
//        for (String str : birds) {
//            newBirds[iter++] = str;
//        }
//        iter = 0;
//        for (double[] attrs : birdAttrs) {
//            newBirdAttrs[iter++] = attrs;
//        }
//        birds = newBirds;
//        birdAttrs = newBirdAttrs;

        // Second method
        birds = Arrays.copyOf(birds, birdTypeMax);
        birdAttrs = Arrays.copyOf(birdAttrs, birdTypeMax);
    }

    static void sellBirds(String bird, int count) {
        int birdIdx = findBirdInStorage(bird);
        if (birdIdx >= 0 && birdAttrs[birdIdx][COUNT] >= count) {
            birdAttrs[birdIdx][COUNT] -= count;
            birdAttrs[birdIdx][SOLD] += count;
        } else if (birdIdx >= 0) {
            System.out.println("At the moment in storage" + birdAttrs[birdIdx][COUNT] + " "+bird + "s");
        } else {
            System.out.println("We don't sell " + bird + "s");
        }
    }

    static void addToSold(String bird, int count) {
        int birdIdx = findBirdInStorage(bird);
        if (birdIdx >= 0) {
            birdAttrs[birdIdx][SOLD] += count;
        }
    }


    static int findBirdInStorage(String newBird) {
        for (int i = 0; i < birdTypeMax; i++) {
            if (birds[i] != null && birds[i].equals(newBird)) {
                return i;
            }
        }
        return -1;

    }

    static void printHowManyBirdsSold()
    {
        System.out.println("SOLD:");
        for (int i = 0; i < birdTypeNum; i++) {
            System.out.println(" - "+birds[i]+": "+birdAttrs[i][SOLD]);
        }
    }

    static void getBirdCount(String bird)
    {
        int birdIdx = findBirdInStorage(bird);
        if (birdIdx >= 0) {
            System.out.println("We have " + birdAttrs[birdIdx][COUNT] + " " + bird + "s");
        } else {
            System.out.println("We don't sell such " + bird + "s");
        }
    }

    static void printBirdsLess3()
    {
        System.out.println("Birds less then 3 in stock:");
        for (int i = 0; i < birdTypeNum; i++) {
            if (birdAttrs[i][COUNT] < 3) System.out.println(" - "+birds[i]);
        }
    }

    static void swap(double[][] data, int idx1, int idx2)
    {
        if(data[idx1] != data[idx2]){
            double[] temp2 = data[idx2];
            data[idx2] = data[idx1];
            data[idx1] = temp2;
        }
    }

    static void swap(String[] data, int idx1, int idx2)
    {
        if(data[idx1] != data[idx2]){
            String temp2 = data[idx2];
            data[idx2] = data[idx1];
            data[idx1] = temp2;
        }
    }

    static void printBirdsAttrsQuantity()
    {
        String[] sortedBirds = new String[birdTypeNum];
        double[][] sortedBirdAttrs = new double[birdTypeNum][3];

        for (int i = 0; i < birdTypeNum; i++) {
            sortedBirdAttrs[i] = birdAttrs[i];
            sortedBirds[i] = birds[i];
        }
        for (int i = 0; i < birdTypeNum; i++) {
            int idxMax = i;
            for (int j = i + 1; j < birdTypeNum; j++) {
                if (sortedBirdAttrs[idxMax][COUNT] < sortedBirdAttrs[j][COUNT]) {
                    idxMax = j;
                }
            }
            if (idxMax != i) {
                swap(sortedBirdAttrs, i, idxMax);
                swap(sortedBirds, i, idxMax);
            }
        }

        System.out.println("Birds data in the shop (quantity decrease):");
        for (int i = 0; i < birdTypeNum; i++) {
            System.out.println(" - Bird: "+ sortedBirds[i]+", PRICE "+sortedBirdAttrs[i][PRICE]+", COUNT "+sortedBirdAttrs[i][COUNT]+", SOLD "+sortedBirdAttrs[i][SOLD]);
        }
    }

    static void printBirdsAttrsSold()
    {
        String[] sortedBirds = new String[birdTypeNum];
        double[][] sortedBirdAttrs = new double[birdTypeNum][3];

        for (int i = 0; i < birdTypeNum; i++) {
            sortedBirdAttrs[i] = birdAttrs[i];
            sortedBirds[i] = birds[i];
        }
        for (int i = 0; i < birdTypeNum; i++) {
            int idxMax = i;
            for (int j = i + 1; j < birdTypeNum; j++) {
                if (sortedBirdAttrs[idxMax][SOLD] < sortedBirdAttrs[j][SOLD]) {
                    idxMax = j;
                }
            }
            if (idxMax != i) {
                swap(sortedBirdAttrs, i, idxMax);
                swap(sortedBirds, i, idxMax);
            }
        }

        System.out.println("Birds data in the shop (sell decrease):");
        for (int i = 0; i < birdTypeNum; i++) {
            System.out.println(" - Bird: "+ sortedBirds[i]+", PRICE "+sortedBirdAttrs[i][PRICE]+", COUNT "+sortedBirdAttrs[i][COUNT]+", SOLD "+sortedBirdAttrs[i][SOLD]);
        }
    }

    static void printPresentBirds()
    {
        System.out.println("Present birds:");
        for (int i = 0; i < birdTypeNum ; i++) {
            if (birdAttrs[i][COUNT] != 0) {
                System.out.println(" - "+birds[i]+" "+birdAttrs[i][PRICE]+", quantity: "+birdAttrs[i][COUNT]);
            }
        }
    }

    static void printMarketedBirds()
    {
        System.out.println("Marketed birds:");
        for (int i = 0; i < birdTypeNum ; i++) {
            System.out.println(" - "+birds[i]+" "+birdAttrs[i][PRICE]);
        }
    }

    static void printBirdAttrs(String bird) {
        int birdIdx = findBirdInStorage(bird);
        if (birdIdx >= 0) {
            System.out.println(bird+" - price: "+birdAttrs[birdIdx][PRICE] +", count: "+birdAttrs[birdIdx][COUNT]);
        } else {
            System.out.println("We don't sell such " + bird + "s");
        }
    }

    public static void main(String[] args)
    {
//////////////////// Owner ///////////////////////////////////////////////////
        fillShopWithActualData();
        System.out.println(Arrays.toString(birds));

        addBirdToStorage("Parrot", 15, 10);
        System.out.println(Arrays.toString(birds));

//        printBirdsAttrsQuantity();
//        addBirdToStorage("Parrot", 14, 10);
//        printBirdsAttrsQuantity();

//        removeBirdFromStorage("Parrot");
//        System.out.println(Arrays.toString(birds));
//        printBirdsAttrsQuantity();

//        printHowManyBirdsSold();
//        sellBirds("Eagle", 1);
//        sellBirds("Crow", 1);
//        sellBirds("Horse", 1);
//        printHowManyBirdsSold();

////////////////// Reports ////////////////////////////////////////////
//        printBirdsLess3();
//        getBirdCount("Crow");
//        printHowManyBirdsSold();
//        printBirdsAttrsQuantity();
//        printBirdsAttrsSold();
/////////////////////////////////////////////////////////////

/////////////////// Client //////////////////////////////////////
//        sellBirds("Duck", 4);
//        printPresentBirds();
//        printMarketedBirds();
//        printBirdAttrs("Duck");

/////////////////////// Check array change ////////////////////////////////////
//        addBirdToStorage("Parrot", 15, 10);
//        addBirdToStorage("Parrot1", 15, 10);
//        addBirdToStorage("Parrot2", 15, 10);
//        addBirdToStorage("Parrot3", 15, 10);
//        System.out.println(Arrays.toString(birds));
//
//        addBirdToStorage("Parrot4", 15, 10);
//        addBirdToStorage("Parrot5", 15, 10);
//        System.out.println(Arrays.toString(birds));
//        addBirdToStorage("Parrot6", 15, 10);
//        System.out.println(Arrays.toString(birds));
//        System.out.println(Arrays.deepToString(birdAttrs));
//
//        addBirdToStorage("Parrot7", 15, 10);
//        System.out.println(Arrays.toString(birds));
//        System.out.println(Arrays.deepToString(birdAttrs));
//        addBirdToStorage("Parrot8", 15, 10);
//        addBirdToStorage("Parrot9", 15, 10);
//        System.out.println(Arrays.toString(birds));
//        System.out.println(Arrays.deepToString(birdAttrs));

    }

    static void fillShopWithActualData()
    {
        addBirdToStorage("Crow", 1, 20);
        addBirdToStorage("Eagle", 5, 23);
        addBirdToStorage("Duck", 0.5, 4);
        addToSold("Crow", 3);
        addToSold("Eagle", 1);
        addToSold("Duck", 23);

    }
}
