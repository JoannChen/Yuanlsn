package com.zuoyu.yuanlsn.application

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.zuoyu.yuanlsn.R
import com.zuoyu.yuanlsn.base.BaseActivity


/**
 * Function：标题管理类，布局中不需要include标题文件，在父类中配置即可
 *
 * Created by JoannChen on 2017/2/28 09:24
 * E-mail:q8622268@163.com
 */
class TitleManage(private val context: Context) : View.OnClickListener {

    // 标题栏所在的父布局
    /**
     * 获取当前标题栏视图
     *
     * @return titleView
     */
    var titleView: View? = null
        private set

    // 标题栏文字
    private var titleText: TextView? = null

    // 图标按钮（返回按钮默认是显示的）
    private var leftImg: ImageView? = null
    private var rightImg: ImageView? = null

    // 文字按钮
    private var leftText: TextView? = null
    private var rightText: TextView? = null


    init {
        initView()
    }

    /**
     * 初始化组件
     */
    private fun initView() {

        titleView = View.inflate(context, R.layout.layout_title, null)

        titleText = titleView?.findViewById(R.id.tv_title) as TextView

        // 图标按钮
        leftImg = titleView?.findViewById(R.id.iv_left) as ImageView
        rightImg = titleView?.findViewById(R.id.iv_right) as ImageView

        // 文字按钮
        leftText = titleView?.findViewById(R.id.tv_left) as TextView
        rightText = titleView?.findViewById(R.id.tv_right) as TextView


        //  返回按钮默认是显示的
        leftImg!!.setOnClickListener { (context as BaseActivity).finish() }

    }

    override fun onClick(view: View) {

    }

    /**
     * 隐藏标题栏，用于自定义标题栏样式时
     */
    fun hideTitle() {
        titleView!!.visibility = View.GONE
    }


    /**
     * 显示标题栏，仅显示标题文字，左侧按钮隐藏
     *
     * @param title 标题文字
     */
    fun showTitle(title: String?) {
        titleView!!.visibility = View.VISIBLE
        if (title != null) {
            titleText!!.text = title
            leftImg!!.visibility = View.GONE
        }
    }

    /**
     * 设置背景颜色
     *
     * @param bgColor 背景颜色
     */
    fun setTitleBgRes(bgColor: Int) {
        titleView!!.setBackgroundResource(bgColor)
    }

    /**
     * 设置标题栏文字
     *
     * @param title 文字
     */
    fun setTitleText(title: String) {
        if (!TextUtils.isEmpty(title)) {
            titleText!!.text = title
        }
    }

    /**
     * 设置标题栏文字和颜色
     *
     * @param title     文字
     * @param textColor 文字颜色
     */
    fun setTitleText(title: String, textColor: Int) {
        if (!TextUtils.isEmpty(title)) {
            titleText!!.text = title
            titleText!!.setTextColor(textColor)

        }
    }

    /**
     * 设置左侧按钮显示的图标
     * 默认显示返回按钮，
     * 若传入值为0，则不显示左侧按钮
     *
     * @param icon 图标资源id
     */
    fun setLeftBtn(icon: Int) {
        leftImg!!.visibility = if (icon > 0) View.VISIBLE else View.GONE
        leftImg!!.setImageResource(icon)
    }


    /**
     * 设置左侧按钮显示的文字
     *
     * @param text 文字
     */
    fun setLeftText(text: String) {
        leftText!!.visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        leftText!!.text = text
    }

    /**
     * 设置左侧按钮显示的文字和颜色
     *
     * @param text  文字
     * @param color 文字颜色
     */
    fun setLeftText(text: String, color: Int) {
        leftText!!.visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        leftText!!.text = text
        leftText!!.setTextColor(color)
    }


    /**
     * 设置右侧按钮显示的图标
     *
     * @param icon 图标资源id
     */
    fun setRightBtn(icon: Int) {
        rightImg!!.visibility = if (icon > 0) View.VISIBLE else View.GONE
        rightImg!!.setImageResource(icon)
    }


    /**
     * 设置右侧按钮显示的文字
     *
     * @param text 文字
     */
    fun setRightText(text: String) {
        rightText!!.visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        rightText!!.text = text
    }

    /**
     * 设置右侧按钮显示的文字和颜色
     *
     * @param text  文字
     * @param color 文字颜色
     */
    fun setRightText(text: String, color: Int) {
        rightText!!.visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        rightText!!.text = text
        rightText!!.setTextColor(color)
    }

    /**
     * 设置左侧按钮的点击事件
     *
     * @param listener 监听事件
     */
    fun setLeftBtnOnClick(listener: View.OnClickListener) {


        if (leftImg!!.visibility == View.VISIBLE) {
            leftImg!!.setOnClickListener(listener)
        } else if (leftText!!.visibility == View.VISIBLE) {
            leftText!!.setOnClickListener(listener)
        }

    }


    /**
     * 设置右侧按钮的点击事件
     *
     * @param listener 监听事件
     */
    fun setRightBtnOnClick(listener: View.OnClickListener) {

        if (rightImg!!.visibility == View.VISIBLE) {
            rightImg!!.setOnClickListener(listener)
        } else if (rightText!!.visibility == View.VISIBLE) {
            rightText!!.setOnClickListener(listener)
        }

    }


    /**
     * 判断右侧按钮是否可点击
     *
     * @param isClick true or false
     */
    fun setRightBtnOnClick(isClick: Boolean) {
        rightImg!!.isEnabled = isClick
        if (isClick) {
            rightImg!!.alpha = 1f
        } else {
            rightImg!!.alpha = 0.2f
        }

    }


}


