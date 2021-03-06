/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.view.TintableBackgroundView;

import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;

import org.jetbrains.annotations.NotNull;

public class QMUISkinRuleBgTintColorHandler extends QMUISkinRuleColorStateListHandler {

    @Override
    protected void handle(@NotNull View view, @NotNull String name, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }else{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                view.setBackgroundTintList(colorStateList);
            }
            else {
                QMUISkinHelper.warnRuleNotSupport(view, name);
            }
        }
    }
}
