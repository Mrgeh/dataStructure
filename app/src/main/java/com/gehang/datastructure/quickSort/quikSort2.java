package com.gehang.datastructure.quickSort;

import java.util.Arrays;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.quickSort
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/24 15:40
 */
public class quikSort2 {
    public static int[] countSort(int[] array){
        //1，得到数列的最大值
        int max =array[0];
        int min =array[0];
        for (int i = 1; i <array.length ; i++) {
            if (array[i]>max){
                max=array[i];
            }
            if (array[i]<min){
                min=array[i];
            }
        }
        int d = max-min;
        //2,创建统计数组并统计对应元素的个数
        int[] countArray = new int [d+1];
        for (int i = 0; i <array.length; i++) {
            countArray[array[i]-min]++;
        }
        //3,统计数组做变形，后面的元素都等于前面元素之和
        for (int i = 1; i <countArray.length ; i++) {
            countArray[i]+= countArray[i-1];
        }
        //4，倒叙遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >=0 ; i--) {
           sortedArray[countArray[array[i]-min]-1]=array[i];
           countArray[array[i]-=min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array=new int[]{95,94,91,98,99,90,99,93,91,92};
        int[] sortedArray =countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
