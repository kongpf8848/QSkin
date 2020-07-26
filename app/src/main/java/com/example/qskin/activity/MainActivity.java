package com.example.qskin.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.qskin.QDPreferenceManager;
import com.example.qskin.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ThemeActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onButton1(View view) {
        QDPreferenceManager.getInstance(this).toogleTheme();
    }

    @OnClick(R.id.button2)
    public void onButton2(View view) {
        startActivity(new Intent(this,TestActivity.class));
    }


}
