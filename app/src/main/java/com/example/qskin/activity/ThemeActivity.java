package com.example.qskin.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.LayoutInflaterCompat;

import com.example.qskin.QDPreferenceManager;
import com.example.qskin.R;
import com.example.qskin.util.LogUtil;
import com.gyf.immersionbar.ImmersionBar;
import com.qmuiteam.qmui.skin.QMUISkinLayoutInflaterFactory;
import com.qmuiteam.qmui.skin.QMUISkinManager;

import java.util.List;

public class ThemeActivity extends BaseActivity {

    private QMUISkinManager mSkinManager;
    private QMUISkinManager.OnSkinChangeListener mOnSkinChangeListener = new QMUISkinManager.OnSkinChangeListener() {
        @Override
        public void onSkinChange(QMUISkinManager skinManager, int oldSkin, int newSkin) {
            LogUtil.d("JACK11", "onSkinChange() called with:oldSkin = [" + oldSkin + "], newSkin = [" + newSkin + "]");
            initStatusBar();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (useQMUISkinLayoutInflaterFactory()) {
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            LayoutInflaterCompat.setFactory2(layoutInflater, new QMUISkinLayoutInflaterFactory(this, layoutInflater));
        }
        if(QDPreferenceManager.getInstance(this).isWhiteTheme()){
            setTheme(R.style.app_skin_white);
        }
        else{
            setTheme(R.style.app_skin_dark);
        }
        super.onCreate(savedInstanceState);
        mSkinManager=QMUISkinManager.defaultInstance(this);
        mSkinManager.register(this);
        mSkinManager.addSkinChangeListener(mOnSkinChangeListener);
    }

    public QMUISkinManager getSkinManager() {
        return mSkinManager;
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        initStatusBar();
    }


    private void initStatusBar(){
        if(QDPreferenceManager.getInstance(this).isWhiteTheme()){
            ImmersionBar.with(this)
                    .statusBarColor(R.color.white)
                    .statusBarDarkFont(true)
                    .navigationBarColor(R.color.white)
                    .navigationBarDarkIcon(true)
                    .init();
        }
        else{
            ImmersionBar.with(this)
                    .statusBarColor(R.color.black)
                    .statusBarDarkFont(false)
                    .navigationBarColor(R.color.black)
                    .navigationBarDarkIcon(false)
                    .init();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSkinManager != null) {
            mSkinManager.unRegister(this);
            mSkinManager.removeSkinChangeListener(mOnSkinChangeListener);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.setting){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected boolean useQMUISkinLayoutInflaterFactory() {
        return true;
    }


}
