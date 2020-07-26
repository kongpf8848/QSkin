package com.example.qskin.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;

public class ThemeUtil {

    public static ColorStateList getAttrColorStateList(Context context, Resources.Theme theme, int attr) {
        if (attr == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        if (!theme.resolveAttribute(attr, typedValue, true)) {
            return null;
        }
        if (typedValue.type >= TypedValue.TYPE_FIRST_COLOR_INT && typedValue.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            return ColorStateList.valueOf(typedValue.data);
        }
        if (typedValue.type == TypedValue.TYPE_ATTRIBUTE) {
            return getAttrColorStateList(context, theme, typedValue.data);
        }
        if (typedValue.resourceId == 0) {
            return null;
        }
        return ContextCompat.getColorStateList(context, typedValue.resourceId);
    }

    private static ColorStateList createColorStateList(int defaultColor, int selectedColor) {
        final int[][] states = new int[2][];
        final int[] colors = new int[2];
        states[0] = new int[] {};
        colors[0] = defaultColor;
        states[1] = new int[] { android.R.attr.state_selected};
        colors[1] = selectedColor;
        return new ColorStateList(states, colors);
    }

    public static int getId(Context context,String name){
        int id = context.getResources().getIdentifier(name, "attr", context.getPackageName());
        return id;
    }
}
