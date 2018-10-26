package com.pablo.generictree;

import java.util.LinkedList;
import java.util.Queue;

public class Helper {
    public static <T> void dfsPreOrder(Tree<T> tree){
        if(tree != null){
            System.out.print(" " + tree.getValue());
            Tree<T> temp = tree.leftMostChild();
            while(temp != null){
                dfsPreOrder(temp);
                temp = temp.rightSibling();
            }
        }

    }

    public static <T> void dfsPostOrder(Tree<T> tree){
        if(tree != null){
            Tree<T> temp = tree.leftMostChild();
            while(temp != null){
                dfsPostOrder(temp);
                temp = temp.rightSibling();
            }
            System.out.print(" " + tree.getValue());
        }
    }

    public static <T> void bfs(Tree<T> tree){
        LinkedList<Tree<T>> queue = new LinkedList<>();
        queue.addLast(tree);
        while(!queue.isEmpty()){
            Tree<T> temp = queue.removeFirst();
            System.out.print(" " + temp.getValue());
            temp = temp.leftMostChild();
            while(temp != null) {
                queue.addLast(temp);
                temp = temp.rightSibling();
            }
        }
    }

    public static<T> int treeLength(Tree<T> tree){
        int maxLength = 0;
        int count = 0;
        LinkedList<Tree<T>> queue = new LinkedList<>();
        queue.addLast(tree);
        while(!queue.isEmpty()){
            maxLength = maxInt(maxLength, count);
            count = 0;
            Tree<T> temp = queue.removeFirst();
            temp = temp.leftMostChild();
            while(temp != null) {
                queue.addLast(temp);
                ++count;
                temp = temp.rightSibling();
            }
        }
        return maxLength;
    }

    private static int maxInt(int value1, int value2){
        return value1 > value2 ? value1 : value2;
    }
}
