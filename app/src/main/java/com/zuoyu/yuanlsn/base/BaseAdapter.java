package com.zuoyu.yuanlsn.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zuoyu.yuanlsn.utils.LogUtil;

import java.util.List;

/**
 * Function：Adapter 基类
 *
 * Created by Joann on 17/2/28 17:44
 * E-mail:q8622268@163.com
 */
public abstract class BaseAdapter extends android.widget.BaseAdapter {

    public Context context;
    public List<?> list;

    public BaseAdapter(Context context, List<?> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        if (list == null) {
            LogUtil.i("集合为null");
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = ViewHolder.Companion.getInstance(context, position, convertView, setLayout(), parent);

//        if( parent instanceof MyGridView){
//            if(((MyGridView) parent).isOnMeasure){
//                return holder.getConvertView();
//            }
//
//            LogUtil.i("MyGridView成立啦");
//        }
//
//        if( parent instanceof PullListView){
//
//            if(((PullListView) parent).isOnMeasure){
//                return holder.getConvertView();
//            }
//            LogUtil.i("PullListView成立啦");
//        }

        getView(holder);
        return holder.getConvertView();
    }

    /**
     * 设置布局ID
     *
     * @return id
     */
    public abstract int setLayout();


    /**
     * 处理数据显示
     *
     * @param holder 临时储存器
     */
    public abstract void getView(ViewHolder holder);

}
