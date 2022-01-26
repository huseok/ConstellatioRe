package com.androidstudy.seok.constellatiore.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.fragment.StarFragment;
import com.blankj.utilcode.util.ActivityUtils;

import java.util.List;

/**
 * @author: seok hzl
 * @date: 2021/12/30
 */
public class MainPagerAdapter extends FragmentStateAdapter{
    private List<Fragment> fragments;

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity,List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }


//
//    private static final int starFrag = 0;
//    private static final int parnterFrag = 1;
//    private static final int luckFrag = 2;
//    private static final int meFrag = 3;
//
//    public MainPagerAdapter(List<Fragment> fragments) {
//        this.fragments = fragments;
//
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_star, parent, false);
//
//        if (viewType == starFrag) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_star, parent, false);
//        }
//        if (viewType == parnterFrag) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_parnter, parent, false);
//        }
//        if (viewType == luckFrag) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_luck, parent, false);
//        }
//        if (viewType == meFrag) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_me, parent, false);
//        }
//        MyViewHolder myViewHolder = new MyViewHolder(view);
//
//        return myViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        switch (position) {
//            case 0:
//                return 0;
//            case 1:
//                return 1;
//            case 2:
//                return 2;
//            case 3:
//                return 3;
//            default:
//                return 0;
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return fragments.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//
//        public MyViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//        }
//    }
}
