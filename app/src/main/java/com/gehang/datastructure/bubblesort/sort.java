package com.gehang.datastructure.bubblesort;

import java.util.Arrays;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.bubblesort
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/9 10:12
 */
public class sort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 4, 6, 7, 9, 8, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void sort(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }

        }
    }

    /**
     * 冒泡排序2
     *
     * @param array
     */
    public static void sort2(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果有元素进行赋值，则当前顺序发生了排序。
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 冒泡排序3
     *
     * @param array
     */
    public static void sort3(int array[]) {
        //记录最后一次交换的位置
        int lastIndex = 0;
        int sortBorder = array.length - 1;
        boolean isSort = true;
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果有元素进行赋值，则当前顺序发生了排序。
                    isSort = false;
                    lastIndex = j;
                }
            }
            sortBorder = lastIndex;
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 冒泡排序4
     *
     * @param array
     */
    public static void sort4(int array[]) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSort = true;
            //奇数轮，从左到右
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果有元素进行赋值，则当前顺序发生了排序。
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
            //偶数轮，从右到左
            isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //标记还未有序，未结束
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }


    }
}
