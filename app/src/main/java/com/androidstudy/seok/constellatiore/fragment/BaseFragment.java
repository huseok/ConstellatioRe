package com.androidstudy.seok.constellatiore.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trello.rxlifecycle4.components.support.RxFragment;

/**
 * @author: seok hzl
 * @date: 2021/12/29
 */
public abstract class BaseFragment extends RxFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();
}
