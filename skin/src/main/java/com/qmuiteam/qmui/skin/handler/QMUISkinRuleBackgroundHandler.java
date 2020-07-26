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

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

import org.jetbrains.annotations.NotNull;

public class QMUISkinRuleBackgroundHandler implements IQMUISkinRuleHandler {

    @Override
    public void handle(@NotNull QMUISkinManager skinManager, @NotNull View view, @NotNull Resources.Theme theme, @NotNull String name, int attr) {
        setBackgroundKeepingPadding(view, QMUIResHelper.getAttrDrawable(view.getContext(), theme, attr));
    }

    public void setBackgroundKeepingPadding(View view, Drawable drawable) {
        int[] padding = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackground(drawable);
        view.setPadding(padding[0], padding[1], padding[2], padding[3]);
    }
}
