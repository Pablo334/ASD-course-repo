package com.pablo.binarysearchtree;

public class Runner {
    public static void main(String[] args){
        Tree<Integer, String> bst = new Tree<>(3, "Pablo");
        bst.insertNode(bst, 4, "blahblah");
        System.out.println("Pablo".compareTo("blahblah"));
    }
}
