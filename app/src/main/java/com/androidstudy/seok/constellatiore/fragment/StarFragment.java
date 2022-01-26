package com.androidstudy.seok.constellatiore.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TableLayout;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.activity.StarAnalysisActivity;
import com.androidstudy.seok.constellatiore.adapter.StarBaseAdapter;
import com.androidstudy.seok.constellatiore.adapter.StarVPadapter;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;
import com.androidstudy.seok.constellatiore.view.NestedScrollableHost;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class StarFragment extends BaseFragment {
    private ViewPager2 starVP;
    private GridView starGV;
    private TabLayout starfrag_tb;
    private List<StarInfoBean.StarinfoBean> mDatas;
    private StarBaseAdapter starBaseAdapter;
    private StarVPadapter starVPadapter;
    private NestedScrollableHost hostVp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_star, container, false);
        initView(view);
        initDate(view);
        return view;
    }

    private void initView(View view) {
        starfrag_tb = view.findViewById(R.id.starfrag_tb);
        starGV = view.findViewById(R.id.starfrag_gv);
        starVP = view.findViewById(R.id.starfrag_vp);
        hostVp = view.findViewById(R.id.hostVp);

    }

    private void initDate(View view) {
        Bundle arguments = getArguments();
        StarInfoBean starInfoBean = (StarInfoBean) arguments.getSerializable("info");
        //获取星座的列表数据
        mDatas = starInfoBean.getStarinfo();
        starBaseAdapter = new StarBaseAdapter(getContext(), mDatas);
        starGV.setAdapter(starBaseAdapter);
        starVPadapter = new StarVPadapter(this.getContext());
        starVP.setAdapter(starVPadapter);
//        starVP.requestDisallowInterceptTouchEvent(false);
        hostVp.requestDisallowInterceptTouchEvent(true);
        setGVListener();
        new TabLayoutMediator(starfrag_tb, starVP, (tab, position) -> {
            tab.setText("obj:" + position);
        }).attach();
    }

    private void setGVListener() {
        starGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StarInfoBean.StarinfoBean bean = mDatas.get(position);
                Intent intent = new Intent(getContext(), StarAnalysisActivity.class);
                intent.putExtra("info", bean);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}