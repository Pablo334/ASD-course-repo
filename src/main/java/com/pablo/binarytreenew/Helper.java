package com.pablo.binarytreenew;


import javafx.util.Pair;

public class Helper {
    public static<T> void dfsPreOrder(Tree<T> tree ){
        if(tree != null){
            System.out.println(tree.getValue() + " ");
            dfsPreOrder(tree.getLeft());
            dfsPreOrder(tree.getRight());
        }
    }

    public static<T> void dfsInOrder(Tree<T> tree){
        if(tree != null){
            dfsInOrder(tree.getLeft());
            System.out.println(tree.getValue() + " ");
            dfsInOrder(tree.getRight());
        }
    }

    public static<T> void dfsPostOrder(Tree<T> tree){
        if(tree != null){
            dfsPostOrder(tree.getLeft());
            dfsPostOrder(tree.getRight());
            System.out.println(tree.getValue() + " ");
        }
    }

    public static int countLevelValue(Tree<Integer> tree, int level){
        int count = 0;
        if(tree == null)
            return 0;
        if(tree.getValue() == level)
            count ++;
        return count + countLevelValue(tree.getLeft(), level+1) + countLevelValue(tree.getRight(), level+1);
    }

    public static int maxLenAscending(Tree<Integer> T){
        int left = 0;
        int right = 0;

        if(T != null){
            if(T.getLeft() != null && T.getValue()<T.getLeft().getValue())
                left = 1 + maxLenAscending(T.getLeft());
            if(T.getRight() != null && T.getValue()<T.getRight().getValue())
                right = 1 + maxLenAscending(T.getRight());
        }
        return max(left, right);
    }

    public static <T extends Comparable<T>> T max(T value1, T value2){
        return value1.compareTo(value2) > 0 ? value1 : value2;
    }

    public static<T> int numFoglie(Tree<T> tree){
        if(tree == null)
            return 0;
        if(tree.getLeft() == null && tree.getRight() == null)
            return 1;
        else
            return numFoglie(tree.getLeft()) + numFoglie(tree.getRight());
    }

    public static<T> int gradoSbilanciamento(Tree<T> tree){
        if(tree == null)
            return 0;
        int currentGrado = Math.abs(numFoglie(tree.getLeft()) - numFoglie(tree.getRight()));
        return max(currentGrado, max(gradoSbilanciamento(tree.getLeft()), gradoSbilanciamento(tree.getRight())));
    }

    public static<T> Pair<Integer, Integer> gradoSbilanciamentoSimple(Tree<T> tree){
        if(tree == null)
            return new Pair<>(0,0);
        if(tree.getLeft()== null && tree.getRight() == null){
            return new Pair<>(1,0);
        }
        Integer leftLeafs, leftMax, rightLeafs, rightMax;
        Pair<Integer, Integer> leftPair = gradoSbilanciamentoSimple(tree.getLeft());
        Pair<Integer, Integer> rightPair = gradoSbilanciamentoSimple(tree.getRight());
        leftLeafs = leftPair.getKey();
        leftMax = leftPair.getValue();
        rightLeafs = rightPair.getKey();
        rightMax = rightPair.getValue();
        return new Pair<>(leftLeafs + rightLeafs, max(max(leftMax, rightMax), Math.abs(leftLeafs-rightLeafs)));

    }

    public static<T> int countChildren(Tree<T> tree){
        int count = 0;
        if(tree == null)
            return 0;
        if(tree.getLeft() != null)
            count++;
        if(tree.getRight() != null)
            count++;
        return count + countChildren(tree.getLeft()) + countChildren(tree.getRight());
    }

    public static<T> int upUnder(Tree<T> tree, int level){
        int count =0;
        if(tree == null)
            return 0;
        if(countChildren(tree) == level)
            count ++;
        return count + upUnder(tree.getLeft(), level+1) + upUnder(tree.getRight(), level+1);
    }

    public static<T> int figliParenti(Tree<T> tree){
        return upUnder(tree, 0);
    }
}
