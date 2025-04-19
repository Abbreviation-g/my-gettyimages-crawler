package com.my.crawler;

public class 打印二叉树测试 {
	public static void main(String[] args) {
        Integer[] tstData1 = {1, null, 2, 2, 4, 5, 3, 6, 1, 7, 8, 9, 3, 9, 9, 9, 2};
        TreeNode tstNode1 = TreeNode.constructTree(tstData1);
        System.out.println("\nTree:");
        垂直打印二叉树.printTree(tstNode1);
        System.out.println("\nHorizontal Tree:");
        水平打印二叉树.printTreeHorizontal(tstNode1);
//        System.out.println("\nPreOrder:");
//        垂直打印二叉树.preOrderPrint(tstNode1);

        Integer[] tstData2 = {1, 2, 3, null, 4, 5, 6, 7, null};
        TreeNode tstNode2 = TreeNode.constructTree(tstData2);
        System.out.println("\nTree:");
        垂直打印二叉树.printTree(tstNode2);
        System.out.println("\nHorizontal Tree:");
        水平打印二叉树.printTreeHorizontal(tstNode2);

    }
}
