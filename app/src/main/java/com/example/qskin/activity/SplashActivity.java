package com.example.qskin.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.qskin.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle(getClass().getSimpleName());
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onButton1(View view) {
       startActivity(new Intent(this,MainActivity.class));
    }


}
