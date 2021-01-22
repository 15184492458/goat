package com.goat.api.lintcode.simple;

import java.util.Stack;

/**
 * 最长有效括号:
 * 描述
     给出一个只包含'(' 和')'的字符串，找出其中最长的左右括号正确匹配的合法子串。

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1:

     输入: "(()"
     输出: 2
     解释: 最长有效括号子串为 "()"
     样例 2:

     输入: ")()())"
     输出: 4
     解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String str = "(()(()";
        System.out.println(longestValidParentheses(str));
    }

    /**
     * @param s: a string
     * @return: return a integer
     */
    public static int longestValidParentheses(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') stack.push(i);
            else {
                stack.pop();
                if(!stack.isEmpty()) {
                    max = Math.max(max,i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
