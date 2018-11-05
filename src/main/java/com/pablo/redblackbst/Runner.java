package com.pablo.redblackbst;

import com.pablo.binarysearchtree.Tree;

public class Runner {
    public static void main(String[] args){
        RedBlackTree<Integer, String> tree = new RedBlackTree<>(5,"Scemottina");
        
        tree.insert(7, "Nom nom");
        tree.insert(125, "bitch");
        tree.insert(2, "dsfasfas");
        tree.insert(9, "sdfasfsafasf");
        tree.insert(4, "sdfassssss");
        RedBlackTree.dfsInOrder(Tree.getRoot(tree));
    }
}
