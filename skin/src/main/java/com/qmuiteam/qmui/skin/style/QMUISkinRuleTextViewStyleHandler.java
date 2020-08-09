package com.qmuiteam.qmui.skin.style;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class QMUISkinRuleTextViewStyleHandler implements IStyleHandler {

    @Override
    public void handle(@NonNull View view, int resId) {
        TextView textView=(TextView)view;
        textView.setTextAppearance(view.getContext(),resId);
    }
}
