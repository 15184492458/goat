package com.goat.api.lintcode.simple;

/**
 * 丢鸡蛋
 * 描述
     楼有 n 层高，鸡蛋若从 k 层或以上扔，就会碎。从 k 层以下扔，就不会碎。

     现在给两个鸡蛋，用最少的扔的次数找到 k。返回最坏情况下次数。

     您在真实的面试中是否遇到过这个题？
     说明
     对于 n = 10， 一种找 k 的初级方法是从 1、2 ... k 层不断找。但最坏情况下要扔 10 次。

     注意有两个鸡蛋可以使用，所以可以从 4、7、9 层扔。这样最坏就只需要 4 次 (例如 k = 9 时)。

     样例
     样例 1：

     输入：100
     输出：14
     样例 2：

     输入：10
     输出：4
 */
public class DropEggs {

    public static void main(String[] args) {
        System.out.println(dropEggs(2147483647));
    }

    public static int dropEggs(int n) {
        // write your code here
//        return dropEggs(2,n);
        return dropEggs3(n);
    }

    public static int  dropEggs3(double n) {
        return (int) Math.ceil(Math.sqrt(2*n + 0.25) - 0.5);
    }

    public static int  dropEggs2(int n) {
         int result = 0;
         int count = 0;
         while (result < n) {
             ++count;
             result += count;
         }
         return count;
    }

    public static int  dropEggs1(int n) {
        double res = 0;
        for(;;res++) {
            double sum = (1 + res) * res / 2;
            if (sum >= n)
                return (int)res;
        }
    }

    //(1)动态规划法:  该算法的空间复杂度是O(nk)，时间复杂度是O(nk^2) n表示鸡蛋数，k代表楼层数
    public static int  dropEggs(int eggs,int floors) {
        //第一步永远是创建动态规划的备忘录,也叫状态转移矩阵
        //记住：二维数组里的length是0-start的，又因为包含层数为0或鸡蛋为0的情况，所以定义行高和列宽的时候自然要加1
        int[][] dp = new int[eggs + 1][floors + 1];
        //第二步永远是考虑边界，也就是初始化动态规划的备忘录
        //先考虑eggs的边界
        for (int i = 0; i != floors + 1; i++) {
            //首先是eggs=0的情况
            dp[0][i] = 0;
            //然后是eggs=1的情况
            //eggs=1的时候，肯定是从第0层一直往上实验
            dp[1][i] = i;
        }
        //再考虑floors的边界
        for (int i = 1; i != eggs + 1; i++) {
            //首先是floors=0的情况
            dp[i][0] = 0;
            //然后是floors=1的情况
            dp[i][1] = 1;
        }
        //第三步就是状态方程了
        //找递推过程中的两个紧邻步骤之间的关系，如何由子结果得到母结果
        //首先，鸡蛋要从2个开始算，因为0个和1个情况你已经考虑完了
        for (int egg = 2; egg != eggs + 1; egg++) {
            //楼层有多高要从2层起步，因为0层和1层的情况你也考虑完了
            for (int floor = 2; floor != floors + 1; floor++) {
                //看这里！这里就是你还有egg个鸡蛋，一共有floor层的子问题！
                //这里定义一个变量来存储最终结果，找到在哪层扔能达到所扔次数最少的目标
                int result = Integer.MAX_VALUE;
                for (int drop = 1; drop != floor + 1; drop++) {
                    //这里！就是在当前子问题中，你从第drop层扔鸡蛋的情况！
                    //第一种情况，哎呀~碎了！那么剩下的问题就转化成了如何在drop-1层，用egg-1个鸡蛋寻找最优
                    int broken = dp[egg - 1][drop - 1];
                    //第二种请看，卧槽~没碎！问题就转化成了如果再floos-drop层，用egg个鸡蛋寻找最优解
                    int unbroken = dp[egg][floor - drop];
                    //两种情况我肯定要取最大值，因为我根本不确定鸡蛋会不会碎，我特么又不是先知
                    int condition = Math.max(broken, unbroken) + 1;
                    //不断的和上一次的结果做比较，只为得到最优的结果，最少的扔鸡蛋次数！
                    result = Math.min(condition, result);
                }
                //当前子问题（当我有egg个鸡蛋，一共有floor层时）已经for循环完了！撒花~~接下来，就是把结果存到我们的结果矩阵里了！
                dp[egg][floor] = result;
            }
        }
        //以上的步骤在不断的往状态矩阵（我把它称作装满结果的大盘子！）填充结果！到这里已经都填充完毕，我们自然就可以取到我们想要的结果啦
        return dp[eggs][floors];
    }
}
