package com.goat.api.lintcode.entrylevel;

/**
 * 斐波纳契数列
     描述
     查找斐波纳契数列中第 N 个数。

     所谓的斐波纳契数列是指：

     前2个数是 0 和 1 。
     第 i 个数是第 i-1 个数和第i-2 个数的和。
     斐波纳契数列的前10个数字是：

     0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

     在测试数据中第 N 个斐波那契数不会超过32位带符号整数的表示范围

     样例
     样例  1:
     输入:  1
     输出: 0

     样例解释:
     返回斐波那契的第一个数字，是0.

     样例 2:
     输入:  2
     输出: 1

     样例解释:
     返回斐波那契的第二个数字是1.
 */
public class Fibonacci {

    public static void main(String[] args) {

    }

    /**
     * 滚动数组优化动态规划
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci2(int n) {
        // write your code here
        if (n == 1) return 0;
        if (n == 2) return 1;
        int beforeOne = 1,beforeTwo = 0;
        for (int i = 2; i < n; ++i) {
            int tmp = beforeTwo;
            beforeTwo = beforeOne;
            beforeOne = tmp + beforeOne;
        }
        return beforeOne;
    }

    /**
     * 动态规划
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci1(int n) {
        // write your code here
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 递归
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci(int n) {
        // write your code here
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
