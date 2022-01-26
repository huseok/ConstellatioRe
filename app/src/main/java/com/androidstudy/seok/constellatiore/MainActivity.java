package com.androidstudy.seok.constellatiore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.androidstudy.seok.constellatiore.adapter.MainPagerAdapter;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;
import com.androidstudy.seok.constellatiore.fragment.LuckFragment;
import com.androidstudy.seok.constellatiore.fragment.MeFragment;
import com.androidstudy.seok.constellatiore.fragment.ParnterFragment;
import com.androidstudy.seok.constellatiore.fragment.StarFragment;
import com.androidstudy.seok.constellatiore.utils.AssetUtils;
import com.google.gson.Gson;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RxAppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup main_RG;
    private Fragment starFrag, parnterFrag, luckFrag, meFrag;
    private ViewPager2 viewPager;
    private List<Fragment> fragments;
    private RadioButton starRb, parnterRb, luckRb, meRb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initData() {

        StarInfoBean starInfoBean = getStarJson();

        Bundle bundle = new Bundle();
        bundle.putSerializable("info", starInfoBean);


        //=====碎片相关=======
        fragments = new ArrayList<>();

        starFrag = new StarFragment();
        starFrag.setArguments(bundle);
        fragments.add(starFrag);

        parnterFrag = new ParnterFragment();
        parnterFrag.setArguments(bundle);
        fragments.add(parnterFrag);

        luckFrag = new LuckFragment();
        luckFrag.setArguments(bundle);
        fragments.add(luckFrag);

        meFrag = new MeFragment();
        meFrag.setArguments(bundle);
        fragments.add(meFrag);

        viewPager.setAdapter(new MainPagerAdapter(this,fragments));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        starRb.setChecked(true);
                        break;
                    case 1:
                        parnterRb.setChecked(true);
                        break;
                    case 2:
                        luckRb.setChecked(true);
                        break;
                    case 3:
                        meRb.setChecked(true);
                        break;
                    default:
                        break;
                }
            }
        });


    }

    private StarInfoBean getStarJson() {
        String json = AssetUtils.getJsonFromAssets(this, "xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarInfoBean infoBean = gson.fromJson(json, StarInfoBean.class);
        AssetUtils.saveBitmapFromAssets(this, infoBean);
        return infoBean;
    }

    protected void initView() {
        main_RG = findViewById(R.id.main_rg);
        main_RG.setOnCheckedChangeListener(this);
        viewPager = findViewById(R.id.main_layout_center);
        starRb = findViewById(R.id.main_rb_star);
        parnterRb = findViewById(R.id.main_rb_parent);
        luckRb = findViewById(R.id.main_rb_luck);
        meRb = findViewById(R.id.main_rb_me);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_rb_star:
                viewPager.setCurrentItem(0);
                break;
            case R.id.main_rb_parent:
                viewPager.setCurrentItem(1);
                break;
            case R.id.main_rb_luck:
                viewPager.setCurrentItem(2);
                break;
            case R.id.main_rb_me:
                viewPager.setCurrentItem(3);
                break;
            default:
                viewPager.setCurrentItem(0);
                break;
        }
    }
}