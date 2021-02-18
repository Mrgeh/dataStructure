package com.gehang.datastructure.pivotsort;

import java.util.Arrays;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.pivotsort
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/18 16:27
 */
public class pivotSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        //递归结束条件，，startindex大于或等于endindex时
        if (startIndex >= endIndex) {
            return;
        }

        //d得到基准元素

        int pivotIndex = parttion(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序。
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分治双边循环法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int parttion(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以随机取)的元素作为基准元素、

        int piovot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移，
            while (left < right && arr[right] > piovot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= piovot) {

                left++;
            }
            //交换left和right指针所指向的元素。
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //piovt和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = piovot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
