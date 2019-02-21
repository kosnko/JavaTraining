package com.luxoft.jva001p1.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T5_TanksMoveToQuadrant extends JPanel
{
    int tankX = 0;
    int tankY = 0;

    int step = 1;
    int msDelay = 5;

    String xCoordinates = "abcdefghi";
    String yCoordinates = "123456789";

    void runTheGame()
    {
        moveToQuadrant("h3");

        //moveToQuadrant("a1");
        sleep(1000);
        moveToQuadrant("e6");
    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * @param direction can be 1 - up, 2 - right, 3 - down, 4 - right
     */
    void move(int direction)
    {
        // TODO SHOULD BE IMPLEMENTED IN CLASS
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
            sleep(msDelay);
            repaint();
        }
    }

    void moveToQuadrant(String quadrant)
    {
        // TODO YOUR CODE HERE
        int xNext = xCoordinates.indexOf(quadrant.charAt(0));
        int yNext = yCoordinates.indexOf(quadrant.charAt(1));

        int xCur = tankX / 64;
        int yCur = tankY / 64;

        int moveX = xNext - xCur;
        int moveY = yNext - yCur;

        while(moveX != 0 || moveY != 0)
        {
            if(moveX > 0)
            {
                move(2);
                moveX -= 1;
            }
            else if(moveX < 0)
            {
                move(4);
                moveX += 1;
            }
            if(moveY > 0)
            {
                move(3);
                moveY -= 1;
            }
            else if(moveY < 0)
            {
                move(1);
                moveY += 1;
            }
        }
    }


    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    public static void main(String[] args) throws Exception
    {
        T5_TanksMoveToQuadrant bf = new T5_TanksMoveToQuadrant();
        bf.runTheGame();
    }

    public T5_TanksMoveToQuadrant() throws Exception
    {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
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
        catch (InterruptedException e)
        {

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
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
                if (i % 2 == 0)
                {
                    cc = new Color(252, 241, 177);
                }
                else
                {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

}