package com.pablo.redblackbst;

import com.pablo.binarysearchtree.Tree;

public class Runner {
    public static void main(String[] args){
        RedBlackTree<Integer, String> tree = new RedBlackTree<>(5,"Scemottina");
        Tree.getRoot(tree).insert(7, "Nom nom");
        Tree.getRoot(tree).insert(9, "ahahahhaha");

        Tree.getRoot(tree).insert(1, "what");
        Tree.getRoot(tree).insert(2, "bitch");
        Tree.getRoot(tree).insert(10, "nigga");
        Tree.getRoot(tree).insert(125, "nigga2");
        Tree.getRoot(tree).insert(3, "sdfasfads");
        Tree.getRoot(tree).insert(4, "sdfsf");
        
        RedBlackTree.dfsInOrder(Tree.getRoot(tree));
    }
}
