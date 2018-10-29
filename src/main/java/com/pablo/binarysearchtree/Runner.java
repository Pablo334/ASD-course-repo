package com.pablo.binarysearchtree;

public class Runner {
    public static void main(String[] args){
        Tree<Integer, String> bst = new Tree<>(3, "Pablo");
        bst.insert(6, "Bitch");
        bst.insert(2, "Lalalalalal");
        bst.insert(5, "Emma lopa");
        bst.insert(154, "Emma lopa 2");
        bst.insert(1, "Silvana");
        Tree.dfsPreOrder(bst);

        System.out.println();
        bst.remove(2);
        Tree.dfsPreOrder(bst);

    }
}
