package com.pablo.binarysearchtree;


public class Tree<K extends Comparable<K>, V> implements Comparable<K>{
    private Tree parent;
    private Tree left;
    private Tree right;
    private K key;
    private V value;

    public Tree(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V lookup(K key){
        Tree<K,V> temp = lookupNode(this, key);
        if(temp != null)
            return temp.getValue();
        else
            return null;
    }

    private Tree<K, V> lookupNode(Tree<K,V> tree, K key){
        Tree<K,V> u = tree;
        while(u != null && u.key != key){
            if(u.compareTo(key) < 0)
                u=u.getLeft();
            else
                u=u.getRight();
        }
        return u;
    }

    public Tree<K,V> min(Tree<K,V> tree){
        Tree<K,V> temp = tree;
        while(temp.getLeft() != null)
            temp = temp.getLeft();
        return temp;
    }

    public Tree<K,V> max(Tree<K,V> tree){
        Tree<K,V> temp = tree;
        while(temp.getRight() != null)
            temp = temp.getRight();
        return temp;
    }

    public Tree<K,V> successorNode(Tree<K,V> tree){
        if(tree == null)
            return tree;
        if(tree.getRight() != null)
            return min(tree);
        else{
            Tree<K,V> parent = tree.getParent();
            while(parent != null && tree == parent.getRight()){
                tree = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }

    public Tree<K,V> predecessorNode(Tree<K,V> tree){
        if(tree == null)
            return tree;
        if(tree.getLeft() != null)
            return max(tree);
        else{
            Tree<K,V> parent = tree.getParent();
            while(parent != null && tree == parent.getLeft()){
                tree = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }

    private void link(Tree<K,V> parent, Tree<K,V> u, K key){
        if(u!=null)
            u.setParent(parent);
        if(parent != null){
            if(parent.compareTo(key) > 0)
                parent.setLeft(u);
            else
                parent.setRight(u);
        }
    }

    public Tree<K,V> insertNode(Tree<K,V> tree, K key, V value){
        Tree<K,V> parent = null;
        Tree<K,V> u = tree;
        while((u != null) && !(u.getKey().equals(key))){
            parent = u;
            u = u.compareTo(key)<0 ? u.getRight() : u.getLeft();
        }
        if(u!=null && u.getKey().equals(key)){
            u.setValue(value);
        }else{
            Tree<K,V> newNode = new Tree<>(key, value);
            link(parent, newNode, key);
            if(parent == null)
                tree = newNode;
        }
        return tree;
    }

    @Override
    public int compareTo(K key) {
        return this.getKey().compareTo(key);
    }

    public Tree<K,V> getParent() { return parent; }

    public void setParent(Tree<K,V> parent) { this.parent = parent; }

    public Tree<K,V> getLeft() { return left; }

    public void setLeft(Tree<K,V> left) { this.left = left; }

    public Tree<K,V> getRight() { return right; }

    public void setRight(Tree<K,V> right) { this.right = right; }

    public K getKey() { return key; }

    public void setKey(K key) { this.key = key; }

    public V getValue() { return value; }

    public void setValue(V value) { this.value = value; }

}
