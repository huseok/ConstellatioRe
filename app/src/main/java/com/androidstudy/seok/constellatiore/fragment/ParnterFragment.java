package com.androidstudy.seok.constellatiore.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.activity.ParnterAnalysisActivity;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;
import com.androidstudy.seok.constellatiore.utils.AssetUtils;
import com.uuch.adlibrary.AdConstant;
import com.uuch.adlibrary.AdManager;
import com.uuch.adlibrary.bean.AdInfo;
import com.uuch.adlibrary.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class ParnterFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ImageView manIv, womanIv;
    Spinner manSp, womanSp;
    Button prizeBtn, analysisBtn;
    private List<StarInfoBean.StarinfoBean> starinfoBeanList;
    private List<String> nameList;
    private Map<String, Bitmap> contentImgMap;
    List advList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parnter, container, false);
        initView(view);
        initeData();
        return view;
    }

    private void initView(View view) {
        manIv = view.findViewById(R.id.parenterfrag_iv_man);
        womanIv = view.findViewById(R.id.parenterfrag_iv_woman);
        manSp = view.findViewById(R.id.parenterfrag_sp_man);
        womanSp = view.findViewById(R.id.parenterfrag_sp_woman);
        prizeBtn = view.findViewById(R.id.parenterfrag_btn_prize);
        analysisBtn = view.findViewById(R.id.parenterfrag_btn_analysis);

        /*??????????????????*/
        prizeBtn.setOnClickListener(this);
        analysisBtn.setOnClickListener(this);
        manSp.setOnItemSelectedListener(this);
        womanSp.setOnItemSelectedListener(this);
    }

    private void initeData() {
        Bundle bundle = getArguments();
        StarInfoBean info = (StarInfoBean) bundle.getSerializable("info");
        starinfoBeanList = info.getStarinfo();
        nameList = new ArrayList<>();
        //????????????????????????????????????
        for (StarInfoBean.StarinfoBean bean : starinfoBeanList) {
            String name = bean.getName();
            nameList.add(name);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_parnter_sp, R.id.item_parnter_tv, nameList);
        manSp.setAdapter(arrayAdapter);
        womanSp.setAdapter(arrayAdapter);
        //???????????????????????????
        String logoname = starinfoBeanList.get(0).getLogoname();
        contentImgMap = AssetUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(logoname);
        manIv.setImageBitmap(bitmap);
        womanIv.setImageBitmap(bitmap);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parenterfrag_btn_prize:
                Toasty.warning(getContext(), "????????????", Toast.LENGTH_SHORT, true).show();
                showDialog();
                break;
            case R.id.parenterfrag_btn_analysis:
                //??????spinner???????????????
                int manPos = manSp.getSelectedItemPosition();
                int womanPos = womanSp.getSelectedItemPosition();
                String manName = starinfoBeanList.get(manPos).getName();
                String womanName = starinfoBeanList.get(womanPos).getName();
                if ("?????????".equals(manName) || "?????????".equals(womanName)) {
                    Toasty.success(getContext(), "??????!????????????????????????", Toast.LENGTH_SHORT, true).show();
                } else {
                    //????????????
                    Toasty.warning(getContext(), "????????????????????????  " + manName + "???" + womanName
                            + "??????????????????????????????", Toast.LENGTH_SHORT, true).show();
                }
//                Intent intent = new Intent(getContext(), ParnterAnalysisActivity.class);
//                intent.putExtra("man_name",manName);
//                intent.putExtra("man_logoname",starinfoBeanList.get(manPos).getLogoname());
//                intent.putExtra("woman_name",womanName);
//                intent.putExtra("woman_logoname",starinfoBeanList.get(womanPos).getLogoname());
//                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void showDialog() {
        advList = new ArrayList();
        AdInfo adInfo = new AdInfo();
        adInfo.setActivityImg("res://com.androidstudy.seok.constellatiore/" + R.drawable.img_1);
        advList.add(adInfo);

        AdManager adManager = new AdManager(getActivity(), advList);
        adManager
                /**
                 * ?????????????????????????????????????????????????????????
                 */
                .setOverScreen(true)
                /**
                 * ??????ViewPager???????????????
                 */
                .setPageTransformer(new DepthPageTransformer())
                //??????????????????????????????
                .setAnimBackViewTransparent(true)
                //????????????????????????????????????
                .setDialogCloseable(true)
                //?????????????????????????????????
                .setBounciness(15)
                //?????????????????????????????????
                .setSpeed(5)
                .setOnImageClickListener(new AdManager.OnImageClickListener() {
                    @Override
                    public void onImageClick(View view, AdInfo advInfo) {
                        Toasty.success(getContext(), "???????????????sir", Toast.LENGTH_SHORT, true).show();
                    }
                })
                .showAdDialog(AdConstant.ANIM_DOWNRIGHT_TO_CENTER);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}