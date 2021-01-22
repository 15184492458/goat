package com.goat.api.lintcode.entrylevel;

/**
 * 整数排序
 * 描述
     给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。

     您在真实的面试中是否遇到过这个题？
     样例
     样例  1:
     输入:  [3, 2, 1, 4, 5]
     输出:  [1, 2, 3, 4, 5]

     样例解释:
     返回排序后的数组。

     样例 2:
     输入:  [1, 1, 2, 1, 1]
     输出:  [1, 1, 1, 1, 2]

     样例解释:
     返回排好序的数组。
 */
public class SortIntegers {

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] array, int start, int end){
        if (end > start) {
            int middle = partition(array, start, end);
            quickSort(array, start, middle - 1);
            quickSort(array, middle + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = start;
        int index = pivot + 1;
        for (int i = index; i <= end; ++i) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
