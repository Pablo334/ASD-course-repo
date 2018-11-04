package com.pablo.redblackbst;

import com.pablo.binarysearchtree.Tree;

public class RedBlackTree<K extends Comparable<K>, V> extends Tree<K,V> {
    private boolean color;

    public RedBlackTree(K key, V value){
        super(key, value);
        this.color=true;
    }

    private boolean isRed(){
        return color;
    }

    private void changeColor(boolean newColor){
        this.color = newColor;
    }

    private RedBlackTree<K,V> rotateLeft(RedBlackTree<K,V> tree){
        RedBlackTree<K,V> temp = (RedBlackTree<K,V>)tree.getRight();
        RedBlackTree<K,V> parent = (RedBlackTree<K,V>)tree.getParent();
        tree.setRight(temp.getLeft());
        if(temp.getLeft() != null)
            temp.getLeft().setParent(tree);
        temp.setLeft(tree);
        tree.setParent(temp);
        temp.setParent(parent);
        if(parent != null){
            if(parent.getLeft()==tree)
                parent.setLeft(temp);
            else
                parent.setRight(temp);
        }
        return temp;
    }

    private RedBlackTree<K,V> rotateRight(RedBlackTree<K,V> tree){
        RedBlackTree<K,V> temp = (RedBlackTree<K,V>)tree.getLeft();
        RedBlackTree<K,V> parent = (RedBlackTree<K,V>)tree.getParent();
        tree.setLeft(temp.getRight());
        if(temp.getRight()!=null)
            temp.getRight().setParent(tree);
        temp.setRight(tree);
        tree.setParent(temp);
        if(parent != null){
            if(parent.getLeft()==tree)
                parent.setLeft(temp);
            else
                parent.setRight(temp);
        }
        return temp;
    }

    private RedBlackTree<K,V> insertNode(RedBlackTree<K,V> tree, K key, V value){
        RedBlackTree<K,V> parent = null;
        RedBlackTree<K,V> u = tree;
        while((u != null) && !(u.getKey().equals(key))){
            parent = u;
            u = (RedBlackTree<K,V>) (u.compareTo(key)<0 ? u.getRight() : u.getLeft());
        }
        if(u!=null && u.getKey().equals(key)){
            u.setValue(value);
        }else{
            RedBlackTree<K,V> newNode = new RedBlackTree<>(key, value);
            link(parent, newNode, key);
            balanceInsert(newNode);
            if(parent == null)
                tree = newNode;
        }
        return tree;
    }

    private void balanceInsert(RedBlackTree<K,V> tree){

    }
}
