package com.androidstudy.seok.constellatiore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.androidstudy.seok.constellatiore.R;

/**
 * @author: seok hzl
 * @date: 2021/12/31
 */
public class StarVPadapter extends RecyclerView.Adapter<StarVPadapter.ViewHolder> {

    private Context mContext;
    // 声明图片数组
    private int[] imgIds = {R.mipmap.pic_guanggao, R.mipmap.pic_star};

    public StarVPadapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star_vp,null );
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(imgIds[position]);
    }

    @Override
    public int getItemCount() {
        return imgIds.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_star_iv);
        }
    }
}
