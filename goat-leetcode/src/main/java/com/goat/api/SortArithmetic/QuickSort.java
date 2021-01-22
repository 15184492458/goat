package com.goat.api.SortArithmetic;

import java.util.Arrays;

/**
 * 快速排序
 *  a、确认列表第一个数据为中间值，第一个值看成空缺（低指针空缺）。
 *　b、然后在剩下的队列中，看成有左右两个指针（高低）。
 *　c、开始高指针向左移动，如果遇到小于中间值的数据，则将这个数据赋值到低指针空缺，并且将高指针的数据看成空缺值（高指针空缺）。
 *     然后先向右移动一下低指针，并且切换低指针移动。
 *　d、当低指针移动到大于中间值的时候，赋值到高指针空缺的地方。然后先高指针向左移动，并且切换高指针移动。重复c、d操作。
 *　e、直到高指针和低指针相等时退出，并且将中间值赋值给对应指针位置。
 *　f、然后将中间值的左右两边看成行的列表，进行快速排序操作。
 * 不稳定排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3,7,8,6,5,4,8,9,7};
        quickSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + "    "));
    }

    public static void quickSort(int[] array) {
        quickSort(array,0,array.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; ++i) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
