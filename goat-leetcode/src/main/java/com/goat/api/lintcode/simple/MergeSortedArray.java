package com.goat.api.lintcode.simple;

import java.util.Arrays;

/**
 * 合并两个有序升序的整数数组A和B变成一个新的数组。新数组也要有序。
 *   样例 1:
     输入: A=[1], B=[1]
     输出:[1,1]
     样例解释: 返回合并后的数组。

     样例 2:
     输入: A=[1,2,3,4], B=[2,4,5,6]
     输出: [1,2,2,3,4,4,5,6]
     样例解释: 返回合并后的数组。
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a = {7};
        int[] b = {5,7};
        Arrays.stream(mergeSortedArray(a,b)).forEach(System.out::print);
    }

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int tmp = 0;
        int[] result = new int[A.length + B.length];
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if (A[i] >= B[j]){
                result[tmp] = B[j];
                ++j;
            }else {
                result[tmp] = A[i];
                ++i;
            }
            ++tmp;
        }
        if (i == A.length){
            System.arraycopy(B,j,result,tmp,B.length - j);
        }
        if (j == B.length){
            System.arraycopy(A,i,result,tmp,A.length - i);
        }
        return result;
    }
}
