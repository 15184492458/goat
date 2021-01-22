package com.goat.api.SortArithmetic;

import java.util.Arrays;

/**
 * 选择排序
 *  a、将第一个值看成最小值
 *　b、然后和后续的比较找出最小值和下标
 *　c、交换本次遍历的起始值和最小值
 *　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
 * 不稳定排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {3,1,6,3,8,0,10,299,7,2};
        selectionSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + "    "));
    }

    public static void selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; ++i){
            int min = array[i],index = i;
            for (int j = i; j < length - 1; ++j) {
                if (array[j + 1] < min) {
                    min = array[j + 1];
                    index = j + 1;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }
}
