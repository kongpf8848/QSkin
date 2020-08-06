package com.example.qskin;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.example.qskin.util.LogUtil;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.skin.QMUISkinManager;

//java.lang.NullPointerException: Attempt to invoke virtual method 'com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
// com.airbnb.lottie.model.animatable.AnimatableFloatValue.createAnimation()' on a null object reference

public class MyApplication extends Application {

    public static volatile Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        LogUtil.setEnable(BuildConfig.DEBUG);
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            LogUtil.d("JACK8", "uncaughtException() called with: t = [" + t + "], e = [" + e + "]");
        });
        QMUILog.setDelegete(new QMUILog.QMUILogDelegate() {
            @Override
            public void e(String tag, String msg, Object... obj) {
                LogUtil.e(tag, msg );
            }

            @Override
            public void w(String tag, String msg, Object... obj) {
                LogUtil.w(tag, msg );
            }

            @Override
            public void i(String tag, String msg, Object... obj) {
                LogUtil.i(tag, msg );
            }

            @Override
            public void d(String tag, String msg, Object... obj) {
                LogUtil.d(tag, msg );
            }

            @Override
            public void printErrStackTrace(String tag, Throwable tr, String format, Object... obj) {

            }
        });
       initSkin(this);

    }

    public static Context getContext() {
        return applicationContext;
    }

    public void initSkin(Context context) {
        QMUISkinManager skinManager = QMUISkinManager.defaultInstance(context);
        skinManager.addSkin(QDPreferenceManager.SKIN_LIGHT, R.style.app_skin_light);
        skinManager.addSkin(QDPreferenceManager.SKIN_DARK, R.style.app_skin_dark);
        int storeSkinIndex = QDPreferenceManager.getInstance(context).getSkinIndex();
        skinManager.changeSkin(storeSkinIndex);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int theme=QDPreferenceManager.getInstance(getContext()).getSkinIndex();
        if ((newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES && theme==QDPreferenceManager.SKIN_LIGHT) {
            QDPreferenceManager.getInstance(getContext()).setSkinIndex(QDPreferenceManager.SKIN_DARK);
        } else if (theme== QDPreferenceManager.SKIN_DARK) {
            QDPreferenceManager.getInstance(getContext()).setSkinIndex(QDPreferenceManager.SKIN_LIGHT);
        }
    }
}
