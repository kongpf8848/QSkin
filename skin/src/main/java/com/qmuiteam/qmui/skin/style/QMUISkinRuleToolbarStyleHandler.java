package com.qmuiteam.qmui.skin.style;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

public class QMUISkinRuleToolbarStyleHandler{

    public void handle( @NonNull View view,int resId) {

        Toolbar toolbar=(Toolbar)view;
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(view.getContext(), resId,androidx.appcompat.R.styleable.Toolbar);
        final Drawable navIcon = a.getDrawable(androidx.appcompat.R.styleable.Toolbar_navigationIcon);
        if (navIcon != null) {
            toolbar.setNavigationIcon(navIcon);
        }
        if (a.hasValue(androidx.appcompat.R.styleable.Toolbar_titleTextColor)) {
            toolbar.setTitleTextColor(a.getColorStateList(androidx.appcompat.R.styleable.Toolbar_titleTextColor));
        }
        if (a.hasValue(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor)) {
            toolbar.setSubtitleTextColor(a.getColorStateList(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor));
        }
        a.recycle();

    }
}
