package com.example.qskin.activity;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.qskin.util.LogUtil;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(getClass().getSimpleName(),"onCreate called");
    }
    @Override
    public void onContentChanged(){
        super.onContentChanged();
        LogUtil.d(getClass().getSimpleName(),"onContentChanged called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(getClass().getSimpleName(), "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(getClass().getSimpleName(), "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(getClass().getSimpleName(), "onPause() called");
    }


    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(getClass().getSimpleName(), "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(getClass().getSimpleName(), "onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(getClass().getSimpleName(), "onRestart() called");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.d(getClass().getSimpleName(), "onNewIntent() called");
    }

}