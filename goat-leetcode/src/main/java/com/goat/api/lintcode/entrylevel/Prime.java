package com.goat.api.lintcode.entrylevel;

import java.util.ArrayList;
import java.util.List;

/**
 *寻找素数
 * 描述
     输出n以内所有的素数。

     保证 n 是100以内的整数。

     样例
     样例 1:

     输入：5
     输出：[2, 3, 5]
 */
public class Prime {

    public static void main(String[] args) {
        prime(73).forEach(x -> System.out.print(x + "    "));
    }

    public static List<Integer> prime(int n) {
        // write your code here
        List<Integer> result = new ArrayList();
        for (int i = 2; i <= n; ++i) {
            int middle = i / 2;
            boolean num = true;
            for (int j = 2; j <= middle; ++j){
                if (i % j == 0)  num = false;
            }
            if (num) result.add(i);
        }
        return result;
    }
}
