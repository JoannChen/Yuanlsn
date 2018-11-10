package com.zuoyu.yuanlsn.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuoyu.yuanlsn.R;
import com.zuoyu.yuanlsn.adapter.RecommendAdapter;
import com.zuoyu.yuanlsn.entity.RecommendEntity;
import com.zuoyu.yuanlsn.utils.ViewUtil;
import com.zuoyu.yuanlsn.widget.ClearEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Function：首页
 *
 * Created by JoannChen on 2017/4/28 17:15
 * E-mail:Q8622268@foxmail.com
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private ClearEditText searchEdit;
    private ImageView messageImgView;
    private GridView projectGridView, headlineGridView;
    private RecommendAdapter adapter;
    private List<RecommendEntity> projectList = new ArrayList<>();
    private List<RecommendEntity> headlineList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


//        搜索框
        searchEdit = (ClearEditText) view.findViewById(R.id.et_search);
        searchEdit.setSingleLine();
        ViewUtil.setViewSize(searchEdit, 840, 92);
        ViewUtil.setPaddingLeft(searchEdit, 100);
        ViewUtil.setPaddingRight(searchEdit, 38);
        ViewUtil.setMarginLeft(searchEdit, 50, ViewUtil.RELATIVELAYOUT);

//        搜索图标
        ImageView searchImgView = (ImageView) view.findViewById(R.id.icon_1);
        ViewUtil.setMarginLeft(searchImgView, 80, ViewUtil.RELATIVELAYOUT);

//        消息按钮
        messageImgView = (ImageView) view.findViewById(R.id.iv_message);
        ViewUtil.setMarginRight(messageImgView, 50, ViewUtil.RELATIVELAYOUT);


//        知识点
        TextView knowledgeText = (TextView) view.findViewById(R.id.tv_knowledge);
        setIconSize(knowledgeText, R.mipmap.icon_h_knowledge);

//        项目
        TextView projectText = (TextView) view.findViewById(R.id.tv_project);
        setIconSize(projectText, R.mipmap.icon_h_project);

//        头条
        TextView headlineText = (TextView) view.findViewById(R.id.tv_headline);
        setIconSize(headlineText, R.mipmap.icon_h_headline);


//        项目列表容器
        projectGridView = (GridView) view.findViewById(R.id.ll_project_container);

//        头条列表容器
        headlineGridView = (GridView) view.findViewById(R.id.ll_headline_container);


        initData();


        adapter = new RecommendAdapter(getContext(), projectList);
        projectGridView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_knowledge:
                break;
            case R.id.tv_project:
                break;
            case R.id.tv_headline:
                break;
            case R.id.iv_message:
                break;

        }
    }

    private void initData() {

        for (int i = 1; i < 5; i++) {
            RecommendEntity entity = new RecommendEntity();
            entity.setPeople(i + "人学习");
            entity.setTitle("Android中文社区(官网) " + i);
            entity.setClasTime(i + "0课时");
            projectList.add(entity);
        }

        for (int i = 1; i < 5; i++) {
            RecommendEntity entity = new RecommendEntity();
            entity.setPeople(i + "人学习");
            entity.setTitle("实例化Java内部类 " + i);
            entity.setClasTime(i + "0课时");
            headlineList.add(entity);
        }


    }


    /**
     * 动态设置DrawableTop图标的大小
     *
     * @param textView 当前组件
     * @param icon     图标
     */
    private void setIconSize(TextView textView, int icon) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), icon);
        drawable.setBounds(0, 0, ViewUtil.getHeight(162), ViewUtil.getHeight(188));
        textView.setCompoundDrawables(null, drawable, null, null);
    }


}
