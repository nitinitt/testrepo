package com.nchhabra.test;

import com.nchhabra.BinarySearchTree;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitinchhabra on 4/9/15.
 */
public class BinarySearchTreeTest {
    @Test
    public void test1()
    {
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> inorderSeq = new ArrayList<Integer>();
        List<Integer> preOrderSeq = new ArrayList<Integer>();

        inorderSeq.add(3);
        inorderSeq.add(4);
        inorderSeq.add(6);
        inorderSeq.add(7);
        inorderSeq.add(8);

        inorderSeq.add(10);

        inorderSeq.add(15);

        preOrderSeq.add(7);
        preOrderSeq.add(4);
        preOrderSeq.add(3);
        preOrderSeq.add(6);
        preOrderSeq.add(10);
        preOrderSeq.add(8);
        preOrderSeq.add(15);

        BinarySearchTree tree1 = tree.createTree(inorderSeq, preOrderSeq);

        BinarySearchTree.printTree(tree1);

    }


}
