package com.zuoyu.yuanlsn.base

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zhy.autolayout.utils.AutoUtils

/**
 * Function：ViewHolder 临时存储器，配合BaseAdapter 使用
 *
 * Created by Joann on 17/2/28 17:44
 * E-mail:q8622268@163.com
 */
class ViewHolder private constructor(context: Context, position: Int, layoutId: Int, parent: ViewGroup) {
    private val views: SparseArray<View>
    /**
     * 获取复用视图
     *
     * @return convertView
     */
    val convertView: View
    var position: Int = 0
        private set


    init {
        this.position = position
        views = SparseArray()
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false)
        convertView.tag = this
        AutoUtils.autoSize(convertView)

    }


    /**
     * 根据ID获取View
     *
     * @param id  组件id
     * @param <T> 组件类型
     * @return 组件对应的view
    </T> */
    fun <T : View> getView(id: Int): T {
        var view: View? = views.get(id)

        if (view == null) {
            view = convertView.findViewById(id)
            views.put(id, view)
        }

        return view as T
    }

    companion object {


        /**
         * 获取ViewHolder实例
         *
         * @param context     上下文对象
         * @param position    下标
         * @param convertView View
         * @param layoutId    布局
         * @param parent      父布局
         * @return ViewHolder
         */
        fun getInstance(context: Context, position: Int, convertView: View?,
                        layoutId: Int, parent: ViewGroup): ViewHolder {

            if (convertView == null) {
                return ViewHolder(context, position, layoutId, parent)
            } else {
                val vh = convertView.tag as ViewHolder
                vh.position = position
                return vh
            }
        }
    }

}
