package com.pablo.redblackbst;

import com.pablo.binarysearchtree.Tree;

public class RedBlackTree<K extends Comparable<K>, V> extends Tree<K,V> {
    private boolean color;

    public RedBlackTree(K key, V value){
        super(key, value);
        this.color=true;
    }

    public boolean isRed(){
        return color;
    }

    private void changeColor(boolean newColor){
        this.color = newColor;
    }

    private static<K extends Comparable<K>,V> RedBlackTree<K,V> rotateLeft(RedBlackTree<K,V> tree){
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

    private static<K extends Comparable<K>,V> RedBlackTree<K,V> rotateRight(RedBlackTree<K,V> tree){
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

    @Override
    protected Tree<K,V> insertNode(Tree<K,V> tree, K key, V value){
        Tree<K,V> parent = null;
        Tree<K,V> u = tree;
        while((u != null) && !(u.getKey().equals(key))){
            parent = u;
            u = u.compareTo(key)<0 ? u.getRight() : u.getLeft();
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
        tree.changeColor(true);
        while(tree != null){
            RedBlackTree<K,V> parent = (RedBlackTree<K,V>)tree.getParent();
            RedBlackTree<K,V> grandpa = ((parent!=null)? (RedBlackTree<K,V>)parent.getParent() : null);
            RedBlackTree<K,V> uncle = (grandpa == null)? null : (RedBlackTree<K,V>)((grandpa.getLeft()==parent)? grandpa.getRight() : grandpa.getLeft());
            if(parent == null){
                tree.changeColor(false);
                tree = null;
            }else if(!parent.isRed()){
                tree = null;
            }else if((uncle != null) && (uncle.isRed())){
                parent.changeColor(false);
                uncle.changeColor(false);
                grandpa.changeColor(true);
                tree = grandpa;
            }else{
                if((grandpa != null) && (tree == parent.getRight()) && (parent == grandpa.getLeft())){
                    rotateLeft(parent);
                    tree = parent;
                }else if((grandpa != null) && (tree == parent.getLeft()) && (parent == grandpa.getRight())){
                    rotateRight(parent);
                    tree = parent;
                }else{
                    if((grandpa != null) && (tree == parent.getLeft()) && (parent== grandpa.getLeft())){
                        rotateRight(grandpa);
                    }else if((grandpa != null) && (tree == parent.getRight()) && (parent == grandpa.getRight())){
                        rotateLeft(grandpa);
                    }
                    parent.changeColor(false);
                    if(grandpa != null)
                        grandpa.changeColor(true);
                    tree = null;
                }
            }
        }
    }

    @Override
    public String toString(){
        String temp = super.toString();
        temp = temp.substring(0, temp.length()-1);
        return temp + ", Color:" + ((this.isRed())? "RED)" : "BLACK)");
    }
}
