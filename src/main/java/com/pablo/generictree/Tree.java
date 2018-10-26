package com.pablo.generictree;

import java.util.LinkedList;

public class Tree<T> {
    private Tree parent;
    private T value;
    private LinkedList<Tree<T>> children = new LinkedList<>();

    public Tree(T value){
        this.setValue(value);
        this.setParent(null);
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedList<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<Tree<T>> children) {
        this.children = children;
    }

    public Tree<T> leftMostChild(){
        if(this.getChildren().size() == 0)
            return null;
        return this.children.getFirst();
    }

    public Tree<T> rightSibling(){
        if(this.getParent() == null)
            return null;
        if(this.getParent().getChildren().indexOf(this) == (this.getParent().getChildren().size() - 1))
            return null;
        return (Tree<T>) this.getParent().getChildren().get(this.getParent().getChildren().indexOf(this) + 1);
    }

    public void insertChild(Tree<T> child){
        child.setParent(this);
        this.getChildren().offerFirst(child);
    }

    public void insertSibling(Tree<T> sibling){
        if(this.getParent()==null)
            return;
        sibling.setParent(this.getParent());
        this.getParent().getChildren().add(1 + this.getParent().getChildren().indexOf(this), sibling);
    }

    public void deleteChild(){
        this.getChildren().removeFirst();
    }

    public void deleteSibling(){
        if(this.getParent()==null)
            return;
        this.getParent().getChildren().remove(this.getParent().getChildren().indexOf(this) + 1);
    }

    public void printList(){
        System.out.print(" " + this.getValue());
        this.getChildren().stream().forEach(Tree::printList);
    }

}
