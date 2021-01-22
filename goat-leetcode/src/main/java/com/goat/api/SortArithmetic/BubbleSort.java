package com.goat.api.SortArithmetic;

import java.util.Arrays;

/**
 * 冒泡排序
 *  a、冒泡排序，是通过每一次遍历获取最大/最小值
 *　b、将最大值/最小值放在尾部/头部
 *　c、然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
 * 稳定排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3,1,6,3,8,0,10,299,7,2};
        bubbleSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + "    "));
    }

    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
