package com.androidstudy.seok.constellatiore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.adapter.AnalysisBeanAdapter;
import com.androidstudy.seok.constellatiore.bean.StarAnalysisBean;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;
import com.androidstudy.seok.constellatiore.utils.AssetUtils;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalysisActivity extends RxAppCompatActivity implements View.OnClickListener {

    TextView titleTv;
    ImageView backIv;
    CircleImageView iconIv;
    TextView nameTv, dateTv;
    RecyclerView analysisLv;
    StarInfoBean.StarinfoBean bean;
    private Map<String, Bitmap> contentImgMap;
    private TextView footTv;
    List<StarAnalysisBean> mDatas;
    private AnalysisBeanAdapter analysisBeanAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysis);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        bean = (StarInfoBean.StarinfoBean) intent.getSerializableExtra("info");
        titleTv.setText("星座详情");
        nameTv.setText(bean.getName());
        dateTv.setText(bean.getDate());
        contentImgMap = AssetUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(bean.getLogoname());
        iconIv.setImageBitmap(bitmap);
        mDatas = new ArrayList<>();
        analysisBeanAdapter = new AnalysisBeanAdapter(mDatas, bean);
        addDataToList();
        analysisLv.setAdapter(analysisBeanAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        analysisLv.setLayoutManager(gridLayoutManager);
    }

    private void addDataToList() {
        StarAnalysisBean bean1 = new StarAnalysisBean("性格特点", bean.getTd(), R.color.lightblue);
        StarAnalysisBean bean2 = new StarAnalysisBean("掌管宫位", bean.getGw(), R.color.lightpink);
        StarAnalysisBean bean3 = new StarAnalysisBean("显阴阳性", bean.getYy(), R.color.lightgreen);
        StarAnalysisBean bean4 = new StarAnalysisBean("最大特性", bean.getTz(), R.color.purple);
        StarAnalysisBean bean5 = new StarAnalysisBean("主管星球", bean.getZg(), R.color.orange);
        StarAnalysisBean bean6 = new StarAnalysisBean("幸运颜色", bean.getYs(), R.color.colorAccent);
        StarAnalysisBean bean7 = new StarAnalysisBean("搭配珠宝", bean.getZb(), R.color.colorPrimary);
        StarAnalysisBean bean8 = new StarAnalysisBean("幸运号码", bean.getHm(), R.color.grey);
        StarAnalysisBean bean9 = new StarAnalysisBean("搭配金属", bean.getJs(), R.color.darkblue);

        mDatas.add(bean1);
        mDatas.add(bean2);
        mDatas.add(bean3);
        mDatas.add(bean4);
        mDatas.add(bean5);
        mDatas.add(bean6);
        mDatas.add(bean7);
        mDatas.add(bean8);
        mDatas.add(bean9);
        //数据源发生变化，通知适配器改变
        analysisBeanAdapter.notifyDataSetChanged();

    }

    private void initView() {

        titleTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        iconIv = findViewById(R.id.staranalysis_iv);
        nameTv = findViewById(R.id.staranalysis_tv_name);
        dateTv = findViewById(R.id.staranalysis_tv_date);
        analysisLv = findViewById(R.id.staranalysis_rv);
        //   添加底部布局
        backIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}