package com.luxoft.jva001p1.demos.nodes;

public class Demo {
    public static void main(String[] args) {
        Node n1 = new Node("node_1");
        n1.setNode(new Node("node_2", new Node("node_3", n1)));
        n1.printName();
    }
}
