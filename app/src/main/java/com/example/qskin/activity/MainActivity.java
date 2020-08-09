package com.example.qskin.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.qskin.QDPreferenceManager;
import com.example.qskin.R;
import com.example.qskin.util.ThemeUtil;
import com.example.qskin.view.RippleAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ThemeActivity {

    @BindView(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onButton1(View view) {
        RippleAnimation.create(view).setDuration(1000).start();
        QDPreferenceManager.getInstance(this).toogleTheme();

    }

    @OnClick(R.id.button2)
    public void onButton2(View view) {
       startActivity(new Intent(this,TestActivity.class));
    }


}
