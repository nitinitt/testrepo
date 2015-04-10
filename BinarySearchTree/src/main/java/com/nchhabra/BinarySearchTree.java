package com.nchhabra;

import java.util.List;

/**
 * Created by nitinchhabra on 4/9/15.
 */
public class BinarySearchTree
{
    private BinarySearchTree leftChild;
    private BinarySearchTree rightChild;
    private int value;

    public static void printTree(BinarySearchTree root)
    {
        if (root==null)
            return;
        printTree(root.leftChild);
        System.out.println(root.value + ":");
        printTree(root.rightChild);
    }

    enum NodeLocation
    {
        IS_LEFT_CHILD,
        IS_RIGHT_CHILD
    }
    public BinarySearchTree(int value)
    {
        leftChild = null;
        rightChild = null;
        this.value = value;
    }

    public BinarySearchTree(){}

    public BinarySearchTree createTree (List<Integer> inorderSeq, List<Integer> preorderSeq)
    {
        BinarySearchTree root = null;
        BinarySearchTree tempRoot = null;

        if (null==inorderSeq || null == preorderSeq || inorderSeq.size() !=preorderSeq.size())
            return root;

        if (preorderSeq.size()>=1)
        {
            root = new BinarySearchTree(preorderSeq.get(0));
        }


        for (int i=1; i<preorderSeq.size(); i++)
        {
            tempRoot = root;
            /**
             * Iterate till you can find the correct position of the preorderSeq.get(i)
             */
            while(true)
            {
                NodeLocation location = findRelativePostionOfNode(preorderSeq.get(i), tempRoot.value, inorderSeq);

                if (NodeLocation.IS_LEFT_CHILD == location && null==tempRoot.leftChild)
                {
                    //Insert node as left child
                    BinarySearchTree temp = new BinarySearchTree(preorderSeq.get(i));
                    tempRoot.leftChild = temp;
                    break;
                }
                if (NodeLocation.IS_RIGHT_CHILD == location && null==tempRoot.rightChild)
                {
                    //Insert node as right child
                    BinarySearchTree temp = new BinarySearchTree(preorderSeq.get(i));
                    tempRoot.rightChild = temp;
                    break;
                }

                if (NodeLocation.IS_LEFT_CHILD == location && null!=tempRoot.leftChild)
                {
                    tempRoot = tempRoot.leftChild;
                }

                if (NodeLocation.IS_RIGHT_CHILD == location && null!=tempRoot.rightChild)
                {
                    tempRoot = tempRoot.rightChild;
                }
            }

        }
     return root;
    }

    private NodeLocation findRelativePostionOfNode(int preOrderNodeValue, int rootValue, List<Integer> inorderSeq)
    {
        NodeLocation location;
        if (inorderSeq.indexOf(preOrderNodeValue) < inorderSeq.indexOf(rootValue))
            location = NodeLocation.IS_LEFT_CHILD;
        else
            location = NodeLocation.IS_RIGHT_CHILD;
        return location;
    }
}
