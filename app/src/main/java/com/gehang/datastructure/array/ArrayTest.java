package com.gehang.datastructure.array;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.array
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/1/26 11:01
 */
public class ArrayTest {
    public static void main(String[] args) {

        // eat1(10);
        eat2(10);
    }
    private static void eat1(int n){
        for (int i = 0; i <n ; i++) {

            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("吃"+i+"cm面包");



        }
    }
    private static void eat2(int n){
        for (int i = n; i >1 ; i/=2) {

            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("吃"+i+"cm面包");



        }
    }

    private  static  void eat3(int n){
        System.out.println("等待1分钟");
        System.out.println("等待1分钟");
    }

    private  static  void eat4(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.println("等待一分钟");
            }
            System.out.println("吃1cm面包");
        }
    }
}
