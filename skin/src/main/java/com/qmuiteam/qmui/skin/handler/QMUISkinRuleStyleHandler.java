package com.qmuiteam.qmui.skin.handler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.R;
import com.qmuiteam.qmui.skin.style.IStyleHandler;
import com.qmuiteam.qmui.skin.style.QMUISkinRuleImageViewStyleHandler;
import com.qmuiteam.qmui.skin.style.QMUISkinRuleTextViewStyleHandler;
import com.qmuiteam.qmui.skin.style.QMUISkinRuleToolbarStyleHandler;
import com.qmuiteam.qmui.skin.style.TintTypedArray;

public class QMUISkinRuleStyleHandler implements IQMUISkinRuleHandler {

    @Override
    public void handle(@NonNull QMUISkinManager skinManager, @NonNull View view, @NonNull Resources.Theme theme, @NonNull String name, int attr) {

        QMUILog.d("StyleHandler", "handle() called with: view = [" + view + "], name = [" + name + "], attr = [" + attr + "]");
        TypedValue typedValue=new TypedValue();
        if(!theme.resolveAttribute(attr,typedValue,true)){
            return;
        };
        int resId=typedValue.resourceId;

        TintTypedArray ta = TintTypedArray.obtainStyledAttributes(view.getContext(), resId, R.styleable.ViewBackgroundHelper);
        if (ta.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
            Drawable background=ta.getDrawable(R.styleable.ViewBackgroundHelper_android_background);
            if(background!=null) {
                view.setBackground(background);
            }
        }
        ta.recycle();

        IStyleHandler styleHandler=null;

        if(view instanceof Toolbar){
            styleHandler=new QMUISkinRuleToolbarStyleHandler();
        }
        else if(view instanceof TextView){
            styleHandler=new QMUISkinRuleTextViewStyleHandler();
        }
        else if(view instanceof ImageView){
            styleHandler=new QMUISkinRuleImageViewStyleHandler();
        }
        if(styleHandler!=null){
            styleHandler.handle(view,resId);
        }
     }
}
