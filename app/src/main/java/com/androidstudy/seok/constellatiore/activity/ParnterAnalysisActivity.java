package com.androidstudy.seok.constellatiore.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.bean.ParnterAnalysisBean;
import com.androidstudy.seok.constellatiore.utils.AssetUtils;
import com.androidstudy.seok.constellatiore.utils.HttpUtil;
import com.androidstudy.seok.constellatiore.utils.URLContentUtil;
import com.google.gson.Gson;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParnterAnalysisActivity extends RxAppCompatActivity implements View.OnClickListener {

    private TextView mantv, womantv, pdtv, vstv, pftv, bztv, jxtv, zytv, titletv;
    private CircleImageView manIv, womanIv;
    private ImageView backIv;
    private String manName, manLogoname, womanName, womanLogoname, parnterUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parnter_analysis);
        initView();
        initData();
    }

    private void initData() {

        //接收上一个页面传过来的信息
        Intent intent = getIntent();
        manName = intent.getStringExtra("man_name");
        manLogoname = intent.getStringExtra("man_logoname");
        womanName = intent.getStringExtra("woman_name");
        womanLogoname = intent.getStringExtra("woman_logoname");
        //设置能展示的信息
        Map<String, Bitmap> contentImgMap = AssetUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(manLogoname);
        manIv.setImageBitmap(bitmap);
        Bitmap woman_bitmap = contentImgMap.get(womanLogoname);
        womanIv.setImageBitmap(woman_bitmap);

        mantv.setText(manName);
        womantv.setText(womanName);

        pdtv.setText("星座配对-" + manName + "和" + womanName + "配对");
        vstv.setText(manName + " vs " + womanName);
        //获取网络加载地址
        parnterUrl = URLContentUtil.getParnterURL(manName, womanName);
        //加载网络数据()
        sendRequestWithOkHttp(parnterUrl);


    }

    private void sendRequestWithOkHttp(String parnterUrl) {
        final String responseData = HttpUtil.sendGet(parnterUrl);
        Log.e(this.getClass().getSimpleName(), "sendRequestWithOkHttp: " + responseData);
        if (!TextUtils.isEmpty(responseData)) {
            ParnterAnalysisBean parnterAnalysisBean = new Gson().fromJson(responseData, ParnterAnalysisBean.class);
            if (parnterAnalysisBean.getError_code()==0){
                ParnterAnalysisBean.ResultBean result = parnterAnalysisBean.getResult();
                pftv.setText("配对评分："+result.getZhishu()+"  "+result.getJieguo());
                bztv.setText("星座比重："+result.getBizhong());
                jxtv.setText("解析：\n\n"+result.getLianai());
                zytv.setText("注意事项：\n\n"+result.getZhuyi());
            }
        }
    }

    private void initView() {

        mantv = findViewById(R.id.tv_man);
        womantv = findViewById(R.id.tv_woman);
        pdtv = findViewById(R.id.tv_pd);
        vstv = findViewById(R.id.tv_vs);
        pftv = findViewById(R.id.tv_pf);
        bztv = findViewById(R.id.tv_bz);
        jxtv = findViewById(R.id.tv_jx);
        zytv = findViewById(R.id.tv_zy);
        titletv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        manIv = findViewById(R.id.parnteranaly_iv_man);
        womanIv = findViewById(R.id.parnteranaly_iv_woman);
        backIv.setOnClickListener(this);
        titletv.setText("配对详情");
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