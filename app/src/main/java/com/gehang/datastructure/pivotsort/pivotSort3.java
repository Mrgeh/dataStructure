package com.gehang.datastructure.pivotsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.pivotsort
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/19 10:04
 */
public class pivotSort3 {
    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String,Integer>> quickSortStack =new Stack<Map<String,Integer>>();

        //整个梳理中起止下标，以哈希的形式入栈

        Map rootParam = new HashMap();
        rootParam.put("sartIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);
        //循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()){

            //栈顶元素出栈，得到起止下标
            Map<String,Integer> param =quickSortStack.pop();
            //得到基准元素
            int pivotIndex =parttion(arr,param.get("startIndex"),param.get("endIndex"));
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex")<pivotIndex-1){
                Map<String,Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }

        }
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
