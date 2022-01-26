package com.androidstudy.seok.constellatiore.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;
import com.androidstudy.seok.constellatiore.utils.AssetUtils;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author: seok hzl
 * @date: 2021/12/30
 */
public class StarBaseAdapter extends BaseAdapter {
    private Map<String, Bitmap> loginImgMap;
    private List<StarInfoBean.StarinfoBean> mData;
    private Context context;

    public StarBaseAdapter(Context context, List<StarInfoBean.StarinfoBean> mData) {
        this.loginImgMap = AssetUtils.getLogoImgMap();
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_star_gv, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //获取指定位置的数据
        StarInfoBean.StarinfoBean bean = mData.get(position);
        viewHolder.tv.setText(bean.getName());
        Bitmap bitmap = loginImgMap.get(bean.getLogoname());
        viewHolder.cv.setImageBitmap(bitmap);
        return convertView;
    }

    private class ViewHolder {
        CircleImageView cv;
        TextView tv;

        public ViewHolder(View view) {
            this.cv = view.findViewById(R.id.item_star_iv);
            this.tv = view.findViewById(R.id.item_star_tv);
        }
    }

}
