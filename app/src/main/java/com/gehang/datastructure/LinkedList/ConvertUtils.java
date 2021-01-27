package com.gehang.datastructure.LinkedList;

import android.content.Context;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.LinkedList
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/1/27 10:44
 */
public class ConvertUtils {

    public int spToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
