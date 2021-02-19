package com.gehang.datastructure.pivotsort;

import java.util.Arrays;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.pivotsort
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/19 10:04
 */
public class pivotSort2 {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件，，startindex大于或等于endindex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素

        int pivotIndex = parttion(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序。
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分治单边循环法
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int parttion(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以随机取)的元素作为基准元素、

        int piovot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < piovot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //piovt和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = piovot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
