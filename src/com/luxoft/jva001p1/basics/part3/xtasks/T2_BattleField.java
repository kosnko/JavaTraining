package com.luxoft.jva001p1.basics.part3.xtasks;

import java.util.Arrays;

public class T2_BattleField
{

    /**
     * TODO PUT YOUR DESIGN HERE
     */
    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    void runTheGame() throws Exception
    {
        printCurrentBattleField();
    }

    /**
     * Should print battle field to console output.
     */
    private void printCurrentBattleField()
    {
        // TODO YOUR CODE HERE
//        int num = 1;
//        System.out.println("  | A B C D E F G H I");
//        System.out.println("--|------------------");
//        for (String[] strings : battleField) {
//            System.out.print(num+" | ");
//            for (String string : strings) {
//                System.out.print(string+" ");
//            }
//            System.out.println();
//            num++;
//        }

        String[] curreentBattleField = new String[11];
        curreentBattleField[0] = "  | A B C D E F G H I";
        curreentBattleField[1] = "--|------------------";
        for (int i = 2; i < 11 ; i++) {
            curreentBattleField[i] = (i-1)+" | ";
            for (String str: battleField[i-2])
            {
                curreentBattleField[i] += str+" ";
            }
        }
        //System.out.println(Arrays.toString(curreentBattleField));

        for (String str: curreentBattleField) {
            System.out.println(str);
        }

        //System.out.println(Arrays.deepToString(battleField));
    }


    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception
    {
        T2_BattleField bf = new T2_BattleField();
        bf.runTheGame();
    }

    public T2_BattleField() throws Exception
    {
    }
}