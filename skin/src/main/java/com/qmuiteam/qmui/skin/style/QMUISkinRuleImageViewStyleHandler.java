package com.qmuiteam.qmui.skin.style;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.widget.ImageViewCompat;

import com.qmuiteam.qmui.skin.R;

public class QMUISkinRuleImageViewStyleHandler implements IStyleHandler {
    @SuppressLint("RestrictedApi")
    @Override
    public void handle(@NonNull View view, int resId) {
        @SuppressLint("RestrictedApi")
        ImageView imageView=(ImageView)view;
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(view.getContext(), resId, R.styleable.AppCompatImageView);
        final int id = a.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        if (id != -1) {
            Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), id);
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        if (a.hasValue(R.styleable.AppCompatImageView_tint)) {
            ImageViewCompat.setImageTintList(imageView, a.getColorStateList(R.styleable.AppCompatImageView_tint));
        }

        if (a.hasValue(R.styleable.AppCompatImageView_tintMode)) {
            ImageViewCompat.setImageTintMode(imageView, DrawableUtils.parseTintMode(a.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
        }
        a.recycle();
    }
}
