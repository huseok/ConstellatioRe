package com.androidstudy.seok.constellatiore.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.androidstudy.seok.constellatiore.R;

public class MeFragment extends BaseFragment {

    private ViewFlipper meVf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meVf = view.findViewById(R.id.meVf);
        bindVf();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    private void bindVf() {
        ImageView imageView = new ImageView(this.getContext());
        imageView.setImageResource(R.drawable.aaa);
        ImageView imageView1 = new ImageView(this.getContext());
        imageView1.setImageResource(R.drawable.bbb);
        ImageView imageView2 = new ImageView(this.getContext());
        imageView2.setImageResource(R.drawable.ccc);

        meVf.addView(imageView);
        meVf.addView(imageView1);
        meVf.addView(imageView2);
    }
}