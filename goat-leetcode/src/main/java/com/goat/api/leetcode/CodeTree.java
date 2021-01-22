package com.goat.api.leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 序列化和反序列化二叉搜索树:
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

     设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

     编码的字符串应尽可能紧凑。

     示例 1：

     输入：root = [2,1,3]
     输出：[2,1,3]
     示例 2：

     输入：root = []
     输出：[]
      

     提示：

     树中节点数范围是 [0, 104]
     0 <= Node.val <= 104
     题目数据 保证 输入的树是一棵二叉搜索树。
      
     注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class CodeTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//        System.out.println(serialize1(root));
        deserialize(serialize1(root));
    }
    public static String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToStr(root,sb);
        return sb.substring(0, sb.length() - 1);
    }

    public static void treeToStr(TreeNode root,StringBuilder sb){
        if(root != null){
            treeToStr(root.right,sb);
            treeToStr(root.left,sb);
            sb.append(root.val).append(",");
        }
    }

    public static TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] array = data.split(",");
        Stack<Integer> stack = new Stack();
        for(String str : array){
            stack.add(Integer.valueOf(str));
        }
        return buildTree(stack,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static TreeNode buildTree(Stack<Integer> stack,int lower,int upper){
        if (stack.isEmpty()) return null;
        int val = stack.peek();
        if (val < lower || val > upper) return null;
        TreeNode root = new TreeNode(val);
        stack.pop();
        root.left = buildTree(stack,lower,val);
        root.right = buildTree(stack,val,upper);
        return root;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
