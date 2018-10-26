package com.pablo;

//import com.pablo.generictree.Helper;
//import com.pablo.generictree.Tree;
import com.pablo.binarytreenew.Tree;
import com.pablo.binarytreenew.Helper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Tree<Integer> tree = new Tree<>(6);
        tree.setLeft(new Tree<>(12));
        tree.setRight(new Tree<>(4));
        tree.getLeft().setLeft(new Tree<>(245));
        tree.getLeft().setRight(new Tree<>(34));
        tree.getRight().setLeft(new Tree<>(23));
        tree.getRight().setRight(new Tree<>(13));
        tree.getLeft().getLeft().setLeft(new Tree<>(387));
        tree.getLeft().getLeft().setRight(new Tree<>(222));
        /*



        tree.getLeft().getLeft().setRight(new Tree<>(222 ));
        */
        System.out.println(Helper.countLevelValue(tree, 0));
        System.out.println(Helper.maxLenAscending(tree));
        System.out.println(Helper.gradoSbilanciamento(tree));
        System.out.println(Helper.gradoSbilanciamentoSimple(tree).getValue());
        System.out.println(Helper.countChildren(tree.getRight()));
        System.out.println(Helper.figliParenti(tree));


        /*
        Tree<String> tree = new Tree<>("A");
        tree.insertChild(new Tree<>("B"));
        tree.getChildren().getFirst().insertSibling(new Tree<>("D"));
        tree.getChildren().getFirst().insertSibling(new Tree<>("C"));
        tree.getChildren().getFirst().insertChild(new Tree<>("F"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("P"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("S"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("I"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("H"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("G"));
        tree.getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("E"));


        tree.getChildren().getFirst().getChildren().getFirst().insertChild(new Tree<>("Z"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZA"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZB"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZC"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZD"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZE"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZF"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZG"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZH"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZI"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZK"));
        tree.getChildren().getFirst().getChildren().getFirst().getChildren().getFirst().insertSibling(new Tree<>("ZJ"));


        Helper.bfs(tree);
        System.out.println("\n" +Helper.treeLength(tree));
        */

    }
}
