package com.goat.api.SortArithmetic;

import java.util.Arrays;

/**
 * 插入排序
 *  a、默认从第二个数据开始比较。
 *　b、如果第二个数据比第一个小，则交换。然后再用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
 *　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
 * 稳定排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {3,1,6,3,8,0,10,299,7,2};
        insertionSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + "    "));
    }

    public static void insertionSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; ++i){
            for (int j = i; j > 0; --j) {
                if (array[j] < array[j - 1]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }else break;
            }
        }
    }
}
