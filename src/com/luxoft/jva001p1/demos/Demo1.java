package com.luxoft.jva001p1.demos;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args)
    {
        Box[] boxes = new Box[10];
        for (int i = 0; i < 10; i++) {
            boxes[i] = new Box();
            boxes[i].setName("Box_"+i);        }

        for (int i = 0; i < 10; i++) {
            boxes[i].getPens()[0] = getRedPen(i);
            boxes[i].getPens()[1] = getGreenPen(i);
        }

        Pen[] pens = new Pen[2];
        pens[0] = getRedPen(100);
        pens[1] = getGreenPen(200);
        boxes[4].setPens(pens);


        System.out.println(Arrays.toString(boxes));
    }

    static Pen getRedPen(int id)
    {
        Pen pen = new Pen();
        pen.setColour("Red");
        pen.setId(id);
        return pen;
    }

    static Pen getGreenPen(int id)
    {
        Pen pen = new Pen();
        pen.setColour("Green");
        pen.setId(id);
        return pen;
    }

}

