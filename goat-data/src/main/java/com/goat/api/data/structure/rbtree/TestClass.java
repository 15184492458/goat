package com.goat.api.data.structure.rbtree;

public class TestClass {
    public static void main(String[] args) {
        RBTree<Integer, String> tree = new RBTree();
        tree.insert(1,"1");
        tree.insert(3,"1");
        tree.insert(23,"1");
        tree.insert(7,"1");
        tree.insert(234,"1");
        tree.insert(676,"1");
        tree.insert(2,"1");
        tree.insert(78,"1");
        tree.insert(12,"1");
        tree.insert(19,"1");
        System.out.println("前序遍历:");
        tree.preOrderTraversal();
        System.out.println();
        System.out.println("中序遍历:");
        tree.inOrderTraversal();
        System.out.println();
        System.out.println("后序遍历:");
        tree.postOrderTraversal();
        System.out.println();
        System.out.println("广度优先搜索:");
        tree.breadthFirstSearch();
        System.out.println();
        System.out.println("深度优先搜索:");
        tree.depthFirstSearch();
        System.out.println();
        tree.printTree();
    }
}
