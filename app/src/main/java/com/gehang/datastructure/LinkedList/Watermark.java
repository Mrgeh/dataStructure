package com.gehang.datastructure.LinkedList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 给图片加上水印
 * @author Ge Hang
 * @packageName com.gehang.datastructure.LinkedList
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/1/26 17:19
 */

public class Watermark {

    //点击按钮嗲用下面的这个方法
    private void merge() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //假设已有图片
                File zhang = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "zhang.jpg");

                try {
                    Bitmap bitmap1 = BitmapFactory.decodeStream(new FileInputStream(zhang));

                    File zhangphil = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "zhangphil.jpg");
                    if (!zhangphil.exists())
                        zhangphil.createNewFile();

                    int textSize = 60;

                    //中间高度位置添加水印文字。
                    Bitmap bitmap2 = addTextWatermark(bitmap1, "blog.csdn.net/zhangphil", textSize, Color.RED, 0, bitmap1.getHeight() / 2, true);
                    save(bitmap2, zhangphil, Bitmap.CompressFormat.JPEG, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * 给一张Bitmap添加水印文字。
     *
     * @param src      源图片
     * @param content  水印文本
     * @param textSize 水印字体大小 ，单位pix。
     * @param color    水印字体颜色。
     * @param x        起始坐标x
     * @param y        起始坐标y
     * @param recycle  是否回收
     * @return 已经添加水印后的Bitmap。
     */
    public static Bitmap addTextWatermark(Bitmap src, String content, int textSize, int color, float x, float y, boolean recycle) {
        if (isEmptyBitmap(src) || content == null)
            return null;
        Bitmap ret = src.copy(src.getConfig(), true);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Canvas canvas = new Canvas(ret);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Rect bounds = new Rect();
        paint.getTextBounds(content, 0, content.length(), bounds);
        canvas.drawText(content, x, y, paint);
        if (recycle && !src.isRecycled())
            src.recycle();
        return ret;
    }

    /**
     * 保存图片到文件File。
     *
     * @param src     源图片
     * @param file    要保存到的文件
     * @param format  格式
     * @param recycle 是否回收
     * @return true 成功 false 失败
     */
    public static boolean save(Bitmap src, File file, Bitmap.CompressFormat format, boolean recycle) {
        if (isEmptyBitmap(src))
            return false;

        OutputStream os;
        boolean ret = false;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            ret = src.compress(format, 100, os);
            if (recycle && !src.isRecycled())
                src.recycle();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * Bitmap对象是否为空。
     */
    public static boolean isEmptyBitmap(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }

}