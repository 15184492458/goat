package com.goat.api.lintcode.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 二叉查找树中搜索区间
 * 描述
     给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1:

     输入：{5},6,10
     输出：[]
     5
     它将被序列化为 {5}
     没有数字介于6和10之间
     样例 2:

     输入：{20,8,22,4,12},10,22
     输出：[12,20,22]
     解释：
     20
     /  \
     8   22
     / \
     4   12
     它将被序列化为 {20,8,22,4,12}
     [12,20,22]介于10和22之间
 */
public class SearchRange {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        searchRange(root,2,8);
    }

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        preOrder(root,list,k1,k2);
        return list;
    }

    public static void preOrder(TreeNode root,List<Integer> list, int k1, int k2){
        if (root != null){
            preOrder(root.left,list,k1,k2);
            if (root.val >= k1 && root.val <= k2) list.add(root.val);
            preOrder(root.right,list,k1,k2);
        }
    }



    static class TreeNode{
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
