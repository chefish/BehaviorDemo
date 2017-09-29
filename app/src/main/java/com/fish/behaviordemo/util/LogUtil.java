package com.fish.behaviordemo.util;

import android.util.Log;

/**
 * Created by fish on 15/5/25.
 */
public class LogUtil {
//    adb logcat -s FishLog
    //adb logcat -c && adb logcat -s logfish

    public static String TAG = "logfish";

    public static void d(String s) {
        Log.d(TAG, s);
    }


    public static void fish(String s) {
        Log.d(TAG, s);
    }

    public static void d(boolean b)
    {
        Log.d(TAG,String.valueOf(b));
    }

    public static void d(int i)
    {
        Log.d(TAG,String.valueOf(i));
    }
    public static void d(float i)
    {
        Log.d(TAG,String.valueOf(i));
    }

    /**
     * 打印线程id
     */
    public static void thread() {
        long id = Thread.currentThread().getId();
        LogUtil.d("thread id" + id);
    }

    /**
     * 打印线程id
     *
     * @param tag 描述此线程
     */
    public static void thread(String tag) {
        long id = Thread.currentThread().getId();
        LogUtil.d(tag + "thread id" + id);
    }
}