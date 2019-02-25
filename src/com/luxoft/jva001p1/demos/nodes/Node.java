package com.luxoft.jva001p1.demos.nodes;

public class Node {
    private String name;
    private Node node;
    private int printNameCount = 0;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node node) {
        this.name = name;
        this.node = node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void printName()
    {
        if (printNameCount++ < 100){
           System.out.println(name);
           node.printName();
        }
    }
}
