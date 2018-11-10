package com.zuoyu.yuanlsn.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuoyu.yuanlsn.R;
import com.zuoyu.yuanlsn.application.MyApplication;
import com.zuoyu.yuanlsn.utils.ViewUtil;


/**
 * Function：自定义底部选项卡状态
 *
 * Created by JoannChen on 2017/4/28 15:48
 * E-mail:q8622268@163.com
 */
public class TabStateLayout extends RelativeLayout {


    // Tab选项卡背景
    private RelativeLayout tabLLayout;

    // 图标
    private ImageView imageView;

    // 文字
    private TextView textView;


    int checkedIcon, unCheckedIcon;


    public TabStateLayout(Context context) {
        super(context);
        initView(context);
    }

    public TabStateLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public TabStateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /**
     * 初始化布局
     *
     * @param context 上下文对象
     */
    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View convertView = inflater.inflate(R.layout.layout_tab, this);

        tabLLayout = (RelativeLayout) findViewById(R.id.ll_tab);
        imageView = (ImageView) convertView.findViewById(R.id.iv_icon);
        textView = (TextView) convertView.findViewById(R.id.tv_text);


    }

    /**
     * 设置Tab状态
     *
     * @param isChecked 是否选中
     */
    public void setChecked(boolean isChecked) {

        if (isChecked) {

            // 选中状态

            tabLLayout.setBackgroundResource(R.mipmap.bg_tab_checked);
            ViewUtil.setViewSize(tabLLayout, 218, 210);

            imageView.setImageResource(checkedIcon);
            ViewUtil.setViewSize(imageView, 112, 112);

            textView.setTextColor(ContextCompat.getColor(MyApplication.Companion.getInstance(), R.color.font_tab));
            ViewUtil.setTextSize(textView, 36);
            ViewUtil.setMarginTop(textView, 20, ViewUtil.RELATIVELAYOUT);

        } else {

            // 默认状态

            tabLLayout.setBackgroundResource(R.mipmap.bg_tab_unchecked);
            ViewUtil.setViewSize(tabLLayout, 216, 124);

            imageView.setImageResource(unCheckedIcon);
            ViewUtil.setViewSize(imageView, 72, 72);

            textView.setTextColor(ContextCompat.getColor(MyApplication.Companion.getInstance(), R.color.white));
            ViewUtil.setTextSize(textView, 26);
            ViewUtil.setMarginTop(textView, 10, ViewUtil.RELATIVELAYOUT);
        }
    }

    /**
     * 设置图标
     *
     * @param checkedIcon   选中状态
     * @param unCheckedIcon 未选中状态
     */
    public void setIcon(int checkedIcon, int unCheckedIcon) {
        this.checkedIcon = checkedIcon;
        this.unCheckedIcon = unCheckedIcon;
    }

    /**
     * 设置文字
     *
     * @param text 文字描述
     */
    public void setText(String text) {
        textView.setText(text);
    }


}
