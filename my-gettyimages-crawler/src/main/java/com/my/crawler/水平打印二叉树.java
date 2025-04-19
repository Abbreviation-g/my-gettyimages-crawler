package com.my.crawler;

import java.util.List;

public class 水平打印二叉树 {
    private static String traversePreOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String pointerRight = "└──";
        String pointerLeft;
        if (root.right != null) {
            pointerLeft = "├──";
        } else {
            pointerLeft = "└──";
        }

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    private static void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
                                      boolean hasRightSibling) {
        if (node == null) {
            return;
        }

        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.val);

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (hasRightSibling) {
            paddingBuilder.append("│  ");
        } else {
            paddingBuilder.append("   ");
        }

        String paddingForBoth = paddingBuilder.toString();
        String pointerRight = "└──";
        String pointerLeft = (node.right != null) ? "├──" : "└──";

        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
    }

    public static void printTreeHorizontal(TreeNode root) {
        System.out.print(traversePreOrder(root));
    }
}
