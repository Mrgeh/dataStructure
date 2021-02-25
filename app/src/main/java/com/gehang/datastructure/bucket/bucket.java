package com.gehang.datastructure.bucket;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.LinkedList;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.bucket
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/25 10:08
 */
public class bucket {
    public  static double[] bucketSort(double[] array){
        //1.得到数列的最大值和最小值，并计算出差值。d
        double max = array[0];
        double min = array[0];

        for (int i = 1; i <array.length ; i++) {
            if (array[i]>max){
                max= array[i];
            }
            if (array[i]<min){
                min = array[i];
            }
        }
        double d  =max - min;
        //2,初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int j = 0; j <bucketNum ; j++) {
            bucketList.add(new LinkedList<Double>());
        }
        //3,遍历原始数组，将每个元素放入桶中
        for (int j = 0; j <array.length ; j++) {
            int  num = (int)((array[j]-min)*(bucketNum-1)/d);
            bucketList.get(num).add(array[j]);
        }
        //4,对每个桶 内部进行排序
        for (int j = 0; j <bucketList.size() ; j++) {
            //JDK底层采用了归并排序或者归并的优化版本
            Collections.sort(bucketList.get(j));
        }
        //5,输出全部元素
        double[] sortArray = new double[array.length];
        int index = 0 ;
        for (LinkedList<Double> list :bucketList) {
            for (double element:list) {
                sortArray[index] = element;
                index++;
            }
        }
        return sortArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortArray = bucketSort(array);
        System.out.println(Arrays.toString(sortArray));
    }
}
