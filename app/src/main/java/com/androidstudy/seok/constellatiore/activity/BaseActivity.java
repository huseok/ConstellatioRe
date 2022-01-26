package com.androidstudy.seok.constellatiore.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;


/**
 * @author: seok hzl
 * @date: 2021/12/29
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    protected Context mContext;
    protected final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        Log.e(TAG, "onCreate: "+TAG);
    }

    protected abstract void initData();

    protected abstract void initView();
}
