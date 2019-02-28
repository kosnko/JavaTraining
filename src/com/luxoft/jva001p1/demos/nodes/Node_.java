package com.luxoft.jva001p1.demos.nodes;

public class Node_
{
    private String name;

    private Node_ next;


    public static void main(String[] args) throws Exception
    {
        int nextId = 0;

        Node_ first = new Node_(String.valueOf(nextId++));
        Node_ node = first;

        for (int i = 0; i < 100; i++)
        {
            Node_ next = new Node_(String.valueOf(nextId++));
            node.setNextNode_(next);

            node = next;
        }

        node.setNextNode_(first);

        while (true)
        {
            System.out.println(first);
            first = first.getNextNode_();
            Thread.sleep(50);
        }

    }

    @Override
    public String toString()
    {
        return name;
    }

    public Node_(String name)
    {
        this.name = name;
    }

    public Node_ getNextNode_()
    {
        return next;
    }

    public void setNextNode_(Node_ next)
    {
        this.next = next;
    }
}