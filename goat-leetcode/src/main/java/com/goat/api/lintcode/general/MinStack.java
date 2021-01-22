package com.goat.api.lintcode.general;

public class MinStack {

    private transient int[] array;

    private int min;

    private int size;

    public MinStack() {
        // do intialization if necessary
        this.array = new int[16];
        this.size = 0;
    }

    public MinStack(int size) {
        // do intialization if necessary
        this.array = new int[size];
        this.size = 0;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        this.array[size] = number;
        ++size;
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        --size;
        int result = this.array[size];
        this.array[size] = 0;
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            if (this.array[i] < min) {
                min = this.array[i];
            }
        }
        return min;
    }
}
