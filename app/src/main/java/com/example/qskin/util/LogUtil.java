package com.example.qskin.util;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {

    public static final int MAX_LINE_COUNT = 4000;
    public static final String DEFAULT_TAG = "LogUtil";

    public static boolean enable = false;
    public static String TAG = DEFAULT_TAG;


    public static void setEnable(boolean enable) {
        LogUtil.enable = enable;
    }

    public static void v(String msg) {
        print(Log.VERBOSE, TAG, msg);
    }

    public static void v(String tag, String msg) {
        print(Log.VERBOSE, tag, msg);
    }

    public static void d(String msg) {
        print(Log.DEBUG, TAG, msg);
    }

    public static void d(String tag, String msg) {
        print(Log.DEBUG, tag, msg);
    }

    public static void i(String msg) {
        print(Log.INFO, TAG, msg);
    }

    public static void i(String tag, String msg) {
        print(Log.INFO, tag, msg);
    }

    public static void w(String msg) {
        print(Log.WARN, TAG, msg);
    }

    public static void w(String tag, String msg) {
        print(Log.WARN, tag, msg);
    }

    public static void e(String msg) {
        print(Log.ERROR, TAG, msg);
    }

    public static void e(String tag, String msg) {
        print(Log.ERROR, tag, msg);
    }

    private static void print(int priority, String tag, String msg) {
        if (!enable) return;
        if (TextUtils.isEmpty(msg)) return;

        String name = getFunctionName();
        String result = TextUtils.isEmpty(name)? msg : name + msg;
        int len = result.length();
        if (len <= MAX_LINE_COUNT) {
            Log.println(priority, tag, result);
        } else {
            for (int i = 0; i < len; ) {
                if (i + MAX_LINE_COUNT < len) {
                    Log.println(priority, tag, result.substring(i, i + MAX_LINE_COUNT));
                    i += MAX_LINE_COUNT;
                } else {
                    Log.println(priority, tag, result.substring(i));
                    break;
                }
            }
        }


    }

    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts != null) {
            for (int i = 0; i < sts.length; ++i) {
                StackTraceElement st = sts[i];
                if (st.isNativeMethod()) {
                    continue;
                }
                if (st.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (st.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }
                return "[tid:" + Thread.currentThread().getId() + "][" + st.getFileName() + "][" + st.getMethodName() + "][" + st.getLineNumber() + "]";
            }
        }

        return null;

    }


}
