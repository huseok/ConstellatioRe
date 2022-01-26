package com.androidstudy.seok.constellatiore.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidstudy.seok.constellatiore.R;
import com.androidstudy.seok.constellatiore.bean.StarAnalysisBean;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;

import java.util.List;

/**
 * @author: seok hzl
 * @date: 2021/12/31
 */
public class AnalysisBeanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<StarAnalysisBean> mData;
    private Context mContext;
    StarInfoBean.StarinfoBean bean;
    private final int TYPE_FOOTER = 1001;

    public AnalysisBeanAdapter(List<StarAnalysisBean> mData, StarInfoBean.StarinfoBean bean) {
        this.mData = mData;
        this.bean = bean;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder;
        if (viewType != TYPE_FOOTER) {
            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star_analysis, null);
                viewHolder = new MyViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (MyViewHolder) view.getTag();
            }
        } else {
            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_star_analysis, null);
                viewHolder = new FooterViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (FooterViewHolder) view.getTag();
            }
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            StarAnalysisBean starAnalysisBean = mData.get(position);
            ((MyViewHolder) holder).titleTv.setText(starAnalysisBean.getTitle());
            ((MyViewHolder) holder).contentTv.setText(starAnalysisBean.getContent());
            ((MyViewHolder) holder).contentTv.setBackgroundResource(starAnalysisBean.getColor());
        } else {
            ((FooterViewHolder) holder).textView.setText(bean.getInfo());
        }

    }

    @Override
    public int getItemCount() {
        return mData.size() +1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, contentTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.itemstar_tv_title);
            contentTv = itemView.findViewById(R.id.itemstar_tv_content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mData.size()) {
            return TYPE_FOOTER;
        }
        return super.getItemViewType(position);
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.footstar_tv_info);
        }
    }
}
