package com.goat.api.lintcode.entrylevel;

/**
 * 树的最大节点
 *
 * 描述
     在二叉树中寻找值最大的节点并返回。

     样例
     样例1:

     输入:
     {1,-5,3,1,2,-4,-5}
     输出: 3
     说明:
     这棵树如下所示：
     1
     /   \
     -5     3
     / \   /  \
     1   2 -4  -5
     样例 2

     输入:
     {10,-5,2,0,3,-4,-5}
     输出: 10
     说明:
     这棵树如下所示：
     10
     /   \
     -5     2
     / \   /  \
     0   3 -4  -5
 */
public class MaxNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(-4);
        TreeNode node6 = new TreeNode(-5);
        node2.left = node5;
        node2.right = node6;
        TreeNode result = maxNode(root);
        System.out.println(result.val);
    }

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public static TreeNode maxNode(TreeNode root) {
        // write your code here
        if (root == null) return null;
        TreeNode left,right;
        left = maxNode(root.left);
        right = maxNode(root.right);
        if (left != null) {
            if(root.val < left.val) {
                root = left;
            }
        }
        if (right != null) {
            if(root.val < right.val) {
                root = right;
            }
        }
        return root;
    }

    static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
}
