package com.my.crawler;

import java.util.Stack;

public class 二叉树_二叉树的创建_括号创建法 {
	static class BinaryNode {
		char ch;
		BinaryNode leftChild;
		BinaryNode rightChild;

		BinaryNode() {
		}

		BinaryNode(char ch) {
			this.ch = ch;
		}
	}

	static BinaryNode create_tree_by_bracket(String str) {
		Stack<BinaryNode> stack = new Stack<>();
		// 根节点
		BinaryNode rootNode = null;
		int index = 0;
		// 前一个节点
		BinaryNode previousNode = null;
		int k = 1; // 1: left, 2: right
		while (index < str.length()) {
			char ch = str.charAt(index);
			if (ch == ' ') {
				// 无效符号
				index++;
				continue;
			} else if (ch == '(') {
				k = 1;
				// 前一个节点入栈
				stack.add(previousNode);
			} else if (ch == ',') {
				k = 2;
			} else if (ch == ')') {
				// 弹栈
				stack.pop();
			} else {
				// 是一个节点字符
				// 创建节点
				previousNode = new BinaryNode(ch);
				if (rootNode == null) {
					rootNode = previousNode;
				}
				if (stack.isEmpty()) {
					index++;
					continue;
				}
				BinaryNode topNode = stack.peek();
				if (k == 1) {
					topNode.leftChild = previousNode;
				} else if (k == 2) {
					topNode.rightChild = previousNode;
				}
			}
			index++;
		}

		return rootNode;
	}

	public static void main(String[] args) {
		String str = "A(B(D(,G)),C(E,F))";
		BinaryNode rootNode = create_tree_by_bracket(str);
		System.out.println(rootNode);

		printTree(rootNode, 0);
		print(rootNode, 0);
	}

	static void printTree(BinaryNode root, int depth) {
		if (root == null) {
			return;
		}

		// 打印当前节点的值，前面加上适当的缩进
		for (int i = 0; i < depth; ++i) {
			System.out.print("--");
		}
		System.out.println(root.ch);

		// 递归打印左子树和右子树，深度分别加1
		printTree(root.leftChild, depth + 1);
		printTree(root.rightChild, depth + 1);
	}

	static void print(BinaryNode root, int n) {
		int i;
		if (root != null) {
			print(root.rightChild, n + 1);
			for (i = 0; i < n; i++) {
				System.out.print("\t");
			}
			System.out.print(String.format("%2c\n", root.ch));
			print(root.leftChild, n + 1);
		}
	}
}
