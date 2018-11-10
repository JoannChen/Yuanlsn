package com.zuoyu.yuanlsn.adapter;


import android.content.Context;
import android.widget.TextView;

import com.zuoyu.yuanlsn.R;
import com.zuoyu.yuanlsn.base.BaseAdapter;
import com.zuoyu.yuanlsn.base.ViewHolder;
import com.zuoyu.yuanlsn.entity.RecommendEntity;

import java.util.List;

/**
 * Function：
 *
 * Created by JoannChen on 2017/5/2 17:54
 * E-mail:Q8622268@foxmail.com
 */
public class RecommendAdapter extends BaseAdapter {

    public RecommendAdapter(Context context, List<?> list) {
        super(context, list);
    }

    @Override
    public int setLayout() {
        return R.layout.item_home;
    }

    @Override
    public void getView(ViewHolder holder) {

        RecommendEntity entity = (RecommendEntity) list.get(holder.getPosition());

        // 课时
        // 标题
        // 学习人数

        ((TextView) holder.getView(R.id.tv_time)).setText(entity.getClasTime());
        ((TextView) holder.getView(R.id.tv_title)).setText(entity.getTitle());
        ((TextView) holder.getView(R.id.tv_people)).setText(entity.getPeople());

    }
}
