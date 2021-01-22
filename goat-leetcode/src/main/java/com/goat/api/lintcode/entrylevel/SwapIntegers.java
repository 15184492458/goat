package com.goat.api.lintcode.entrylevel;

/**
 *交换数组两个元素
 * 描述
     给你一个数组和两个索引，交换下标为这两个索引的数字

     样例
     样例 1:

     输入:  [1, 2, 3, 4], index1 = 2, index2 = 3
     输出:  交换后你的数组应该是[1, 2, 4, 3]， 不需要返回任何值，只要就地对数组进行交换即可。
     样例解释: 就地交换，不需要返回值。
     样例 2:

     输入:  [1, 2, 2, 2], index1 = 0, index2 = 3
     输出: 交换后你的数组应该是[2, 2, 2, 1]， 不需要返回任何值，只要就地对数组进行交换即可。
     样例解释: 就地交换，不需要返回值。
 */
public class SwapIntegers {

    /**
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
