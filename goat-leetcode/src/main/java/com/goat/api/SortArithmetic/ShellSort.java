package com.goat.api.SortArithmetic;

import java.util.Arrays;

/**
 * 希尔排序
 *  a、基本上和插入排序一样的道理
 *　b、不一样的地方在于，每次循环的步长，通过减半的方式来实现
 *　c、说明：基本原理和插入排序类似，不一样的地方在于。通过间隔多个数据来进行插入排序。
 * 不稳定排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {3,1,6,3,8,0,10,299,7,2,123};
        selectionSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + "    "));
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                int temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
