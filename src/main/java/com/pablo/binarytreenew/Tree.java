package com.pablo.binarytreenew;

public class Tree<T> {
    private Tree<T> parent = null;
    private T value;
    private Tree<T> left = null;
    private Tree<T> right = null;

    public Tree(T value){
        this.setValue(value);
    }


    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> tree) {
        if(this.left == null){
            this.left = tree;
            this.getLeft().setParent(this);
        }
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> tree) {
        if(this.right == null){
            this.right = tree;
            this.getRight().setParent(this);
        }
    }

    public void deleteLeft(){
        deleteTree(this.left);
    }

    public void deleteRight(){
        deleteTree(this.right);
    }

    private void deleteTree(Tree<T> tree){
        if(tree!=null){
            deleteTree(tree.getLeft());
            deleteTree(tree.getRight());
            tree = null;
        }
    }

}
