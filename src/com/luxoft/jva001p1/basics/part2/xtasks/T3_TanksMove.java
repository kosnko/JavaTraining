package com.luxoft.jva001p1.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T3_TanksMove extends JPanel
{
    int tankX = 0;
    int tankY = 0;
    int step = 1;
    int msDelay = 5;

    void runTheGame()
    {
        move(2);
        move(2);
        move(3);
        move(3);
        move(4);
        move(4);
        move(1);
        move(1);

        // TODO fill free to add more tests here

        move(1);
        int i = 0;
        while(i++<10)
        {
            move(2);
        }

    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * !!! Method should ignore wrong commands.
     * For expl: it should do nothing when tank at A0 and direction is 1-UP or 4 - LEFT
     *
     * @param direction can be 1 - up, 2 - right, 3 - down, 4 - left
     */
    void move(int direction)
    {
        // TODO YOUR CODE HERE
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


    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    public static void main(String[] args) throws Exception
    {
        T3_TanksMove bf = new T3_TanksMove();
        bf.runTheGame();
    }

    public T3_TanksMove() throws Exception
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