package com.androidstudy.seok.constellatiore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.androidstudy.seok.constellatiore.fragment.ParnterFragment;

import java.util.HashMap;

/**
 * @author: seok hzl
 * @date: 2021/12/31
 */
public class NestedScrollableHost extends FrameLayout {

    public NestedScrollableHost(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedScrollableHost(@NonNull Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            final ViewParent parent = getParent();
            //诉父View，也就是LinearLayout不要拦截该控件上的触摸事件
            parent.requestDisallowInterceptTouchEvent(true);
            Log.e("aaaaa", "dispatchTouchEvent: aaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            final ViewParent parent = getParent();
            //诉父View，也就是LinearLayout不要拦截该控件上的触摸事件
            parent.requestDisallowInterceptTouchEvent(true);
            Log.e("bbbb", "dispatchTouchEvent: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        }
        return super.onInterceptTouchEvent(ev);
    }
}