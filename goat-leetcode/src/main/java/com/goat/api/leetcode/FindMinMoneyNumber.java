package com.goat.api.leetcode;

/**
 *
 * 你有三种硬币，分别是面值2元、5元、7元。每种硬币都足够多。
 * 买一本书需要27元
 * 如何用最少的硬币组合正好付清，不需要对方找钱。
 */
public class FindMinMoneyNumber {

    public static void main(String[] args) {
        int[] array = {2,5,7};
        System.out.println(coinChange(array,27));
    }

    /**
     * 动态规划：
     *  1.定义状态转移方程
     *      1.1 最后一步：
     *          1.1.1 虽然我们不知道最优策略是什么，但是最优策略肯定是K枚硬币a1,a2,a3,......,ak面值加起来等于27
     *          1.1.2 所以一定有最后的硬币ak。
     *          1.1.3 除掉这枚硬币的面值加起来为27 - ak。
     *                因为是最优策略，所以拼出27 - ak的硬币数一定也是最少的。否则这就不是最优策略。
     *                所以我们的要求是：最少用多少枚硬币可以拼出27 - ak。
     *                原问题是最少用多少枚硬币拼出27.
     *                我们将原问题转化成了一个子问题，而且规模更小：27 - ak。
     *                为了简化定义，我们设状态F(X)=最少用多少枚硬币拼出X。
     *                等等，我们还不知道最后那枚硬币ak是多少，
     *                最后那枚硬币ak只可能是2、5、7
     *                如果ak是2，则F(27) = F(27 - 2) + 1(加上最后一枚硬币2)
     *                如果ak是5，则F(27) = F(27 - 5) + 1(加上最后一枚硬币5)
     *                如果ak是7，则F(27) = F(27 - 7) + 1(加上最后一枚硬币7)
     *                只有这三种可能，除此之外没有其他可能了
     *                需要求最少的硬币数，所以：
     *                  F(X) = Min(F(X-2) + 1,F(X-5) + 1,F(X - 7) + 1)
     *
     *                如果不能拼出就Y，就定义F(Y) = 正无穷
     *                  例如： F(-1),F(-2),F(3) ... = 正无穷
     *                  所以 F(1) = Min(F(-1) + 1,F(-4) + 1,F(-6) + 1) = 正无穷,表示拼不出来。
     *
     *  2.定义初始条件F(0) = 0 (人为定义，不能通过状态转移方程计算)
     *
     *  3.然后计算F(1)，F(2)，......F(27)
     *
     *  4.时间复杂度：
     *      每一步尝试三种硬币，一共27步
     *      与递归相比没有任何重复计算。
     *      算法复杂度（即需要进行的步数）：27 * 3 如果有n中硬币，求拼出m的最小硬币数则为 n * m复杂度
     *
     *  动态规划解题步骤：
     *      1.确定状态
     *          1.1 最后一步（最优策略中使用的最后一枚硬币ak）
     *          1.2 化成子问题（最少的硬币数拼出更小的面值27 - ak）
     *      2.转移方程
     *          F(X) = Min(F(X - 2) + 1,F(X - 5) + 1,F(X - 7) + 1)
     *      3.初始条件和边界条件
     *          F(0) = 0 如果不能拼出Y，则F(Y) = 正无穷
     * @param corns {2, 5, 7}
     * @param target 27
     * @return
     */
    public static int coinChange(int[] corns, int target) {
        if (target == 0 ) return 0;
        //定义dp
        int[] dp = new int[target + 1];
        int len = corns.length;
        //初始化
        dp[0] = 0;
        int i,j;
        //dp[1] dp[2]......dp[27]
        for (i = 1;i <= target;++i){
            dp[i] = Integer.MAX_VALUE;
            for (j = 0;j < len;++j){
                if (i - corns[j] >= 0 && dp[i - corns[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i - corns[j]] + 1,dp[i]);
                }
            }
        }
        for (int x = 0;x < dp.length;++x){
            System.out.print(dp[x] + "  ");
        }
        return dp[target];
    }

    /**
     * 递归思想解决
     * @param target
     * @return
     */
    public static int coinChange1(int target) {
        if (target == 0) return 0;
        int res = target;
        if (target >= 2) {
            res = Math.min(coinChange1(target - 2) + 1,res);
        }
        if (target >= 5) {
            res = Math.min(coinChange1(target - 5) + 1,res);
        }
        if (target >= 7) {
            res = Math.min(coinChange1(target - 7) + 1,res);
        }
        return res;
    }
}
