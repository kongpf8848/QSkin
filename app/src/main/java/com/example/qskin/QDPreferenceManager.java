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

package com.example.qskin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.qmuiteam.qmui.skin.QMUISkinManager;

/**
 * Created by cgspine on 2018/1/14.
 */

public class QDPreferenceManager {
    private static SharedPreferences sPreferences;
    private static QDPreferenceManager sQDPreferenceManager = null;

    public static final int SKIN_LIGHT =1;
    public static final int SKIN_DARK=2;


    private static final String APP_SKIN_INDEX = "app_skin_index";

    private QDPreferenceManager(Context context) {
        sPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static final QDPreferenceManager getInstance(Context context) {
        if (sQDPreferenceManager == null) {
            sQDPreferenceManager = new QDPreferenceManager(context);
        }
        return sQDPreferenceManager;
    }


    public void setSkinIndex(int index) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(APP_SKIN_INDEX, index);
        editor.commit();
    }

    public int getSkinIndex() {
        return sPreferences.getInt(APP_SKIN_INDEX, SKIN_LIGHT);
    }

    public boolean isDarkTheme(){
        return getSkinIndex()==SKIN_DARK;
    }

    public boolean isWhiteTheme(){
        return getSkinIndex()== SKIN_LIGHT;
    }

    public void toogleTheme(){
         if(getSkinIndex()==SKIN_DARK){
             setSkinIndex(SKIN_LIGHT);
             QMUISkinManager.defaultInstance(MyApplication.getContext()).changeSkin(SKIN_LIGHT);
         }
         else if(getSkinIndex()== SKIN_LIGHT){
             setSkinIndex(SKIN_DARK);
             QMUISkinManager.defaultInstance(MyApplication.getContext()).changeSkin(SKIN_DARK);
         }
    }
}
