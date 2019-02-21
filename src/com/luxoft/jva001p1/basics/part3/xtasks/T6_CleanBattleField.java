package com.luxoft.jva001p1.basics.part3.xtasks;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class T6_CleanBattleField extends JPanel
{

    final boolean COLORED_MODE = false;
    final boolean IS_GRID = true;

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - top, 2 - right, 3 - down, 4 - left
    int tankDirection = 1;

    int tankX = 128;
    int tankY = 512;

    int bulletX = -100;
    int bulletY = -100;

    int tankSpeed = 10;
    int bulletSpeed = 1;

    final String BRICK = "B";
    final String BLANK = " ";

    int step = 1;

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

        clean();
    }

    /**
     *
     *  When method called tank should destroy all the objects on battle field in less then 30 seconds.
     *
     */
    void clean()
    {
        // TODO YOUR CODE HERE
        turn(1);
        tankX = 128;
        tankY = 256;
        boolean downComplete = false;

        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 30_000) //bulletX = -100; bulletY = -100;
        {
            if(tankDirection == 1)
            {
                if (isThereBrick()) fire();
                else turn(3);
            }
            else if(tankDirection == 2)
            {
                if (isThereBrick()) fire();
                else turn(4);
            }
            else if(tankDirection == 3)
            {
                if (isThereBrick()) fire();
                else turn(2);
            }
            else if(tankDirection == 4)
            {
                if (isThereBrick()) fire();
                else if (!downComplete) {
                        if (tankY == BF_HEIGHT - 64)
                            downComplete = true;
                        else
                            move(3);
                    } else
                        if (tankY>0) move(1); else System.out.println("Cleaned!");
            }

        }
        System.out.println("30 seconds have elapsed!");
    }

    boolean isThereBrick()
    {
        if(tankDirection == 1)
        {
            for (int i = tankY/64 - 1; i >= 0 ; i--) {
                if(battleField[i][tankX/64] == BRICK) return true;
            }
        }
        else if(tankDirection == 2)
        {
            for (int i = tankX/64 + 1; i < 9 ; i++) {
                if(battleField[tankY/64][i] == BRICK) return true;
            }
        }
        else if(tankDirection == 3)
        {
            for (int i = tankY/64 + 1; i < 9 ; i++) {
                if(battleField[i][tankX/64] == BRICK) return true;
            }
        }
        else if(tankDirection == 4)
        {
            for (int i = tankX/64 - 1; i >= 0 ; i--) {
                if(battleField[tankY/64][i] == BRICK) return true;
            }
        }
        return false;
    }

    /**
     *
     * When called tank should produce new bullet.
     * This bullet should smoothly move to the opposite side.
     *
     * Bullet should be destroyed when rich the opposite side.
     *
     * When the bullet shoot something method would clean appropriate quadrant and destroy the bullet.
     */
    void fire()
    {
        // TODO SHOULD BE ALREADY IMPLEMENTED
        if (tankDirection == 1) {
            bulletX = tankX+32-7;
            bulletY = tankY;
            while (bulletY > 0 && false == checkAndProcessInterception()) {
                bulletY -=step;
                sleep(bulletSpeed);
                repaint();
            }
        } else if (tankDirection == 2) {
            bulletX = tankX+64-14;
            bulletY = tankY+32-7;
            while (bulletX < BF_WIDTH - 14 && false == checkAndProcessInterception()) {
                bulletX +=step;
                sleep(bulletSpeed);
                repaint();
            }
        } else if (tankDirection == 3) {
            bulletX = tankX+32-7;
            bulletY = tankY+64-14;
            while (bulletY < BF_HEIGHT - 14 && false == checkAndProcessInterception()) {
                bulletY +=step;
                sleep(bulletSpeed);
                repaint();
            }
        } else if (tankDirection == 4) {
            bulletX = tankX;
            bulletY = tankY+32-7;
            while (bulletX > 0 && false == checkAndProcessInterception()) {
                bulletX -=step;
                sleep(bulletSpeed);
                repaint();
            }
        }
        bulletX = -100;
        bulletY = -100;
        repaint();
    }

    /**
     *
     * Should return true if bullet located in non-empty quadrant.
     *
     */
    private boolean checkAndProcessInterception()
    {
        // TODO SHOULD BE ALREADY IMPLEMENTED
        int[] quadrant = getQuadrant(bulletX, bulletY);
        if(battleField[quadrant[1]][quadrant[0]] == BRICK)
        {
            if (tankDirection == 1 && bulletY % 64 + 13 > 64) {
                return false;
            } else if (tankDirection == 4 && bulletX % 64 + 13 > 64) {
                return false;
            } else {
                battleField[quadrant[1]][quadrant[0]] = BLANK;
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    private void printCurrentBattleField()
    {
        for (String[] row : battleField)
        {
            System.out.println(Arrays.toString(row));
        }
    }

    int[] getQuadrant(int x, int y)
    {
        return new int[] {x / 64, y / 64};
    }

    void move(int direction)
    {
        // TODO SHOULD BE ALREADY IMPLEMENTED
        turn(direction);
        int[] quadrant = getQuadrant(tankX, tankY);
        if(battleField[quadrant[1]][quadrant[0]] == BRICK)
        {
            return;
        }

        int i = 0;
        while (i < 64)
        {
            if(direction == 1 && tankY != 0)
            {
                tankY -=step;
            }
            else if(direction == 2 && tankX != BF_WIDTH - 64)
            {
                tankX +=step;
            }
            else if(direction == 3 && tankY != BF_HEIGHT - 64)
            {
                tankY +=step;
            }
            else if(direction == 4 && tankX != 0)
            {
                tankX -=step;
            }
            else
            {
                break;
            }
            i += step;
            sleep(tankSpeed);
            repaint();
        }
    }

    void turn(int direction)
    {
        tankDirection = direction;
        repaint();
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception
    {
        T6_CleanBattleField bf = new T6_CleanBattleField();
        bf.runTheGame();
    }

    public T6_CleanBattleField() throws Exception
    {
        JFrame frame = new JFrame("YOUR TANK SHOULD FIRE!!!");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (Exception ignore)
        {
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        paintBorders(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDirection == 1)
        {
            g.fillRect(tankX + 20, tankY, 24, 34);
        }
        else if (tankDirection == 3)
        {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        }
        else if (tankDirection == 4)
        {
            g.fillRect(tankX, tankY + 20, 34, 24);
        }
        else
        {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }

    private void paintBorders(Graphics g)
    {
        for (int j = 0; j < battleField.length; j++)
        {
            for (int k = 0; k < battleField.length; k++)
            {
                if (battleField[j][k].equals("B"))
                {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);

                    if (IS_GRID)
                    {
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(x, y, 64, 64);
                    }
                }
            }
        }
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (COLORED_MODE)
                {
                    if (i % 2 == 0)
                    {
                        cc = new Color(252, 241, 177);
                    }
                    else
                    {
                        cc = new Color(233, 243, 255);
                    }
                }
                else
                {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

    private String getQuadrantXY(int v, int h)
    {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

}