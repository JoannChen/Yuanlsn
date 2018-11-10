package com.zuoyu.yuanlsn.entity

import com.zuoyu.yuanlsn.base.BaseEntity

/**
 * <pre>
 * Function：
 *
 * Created by JoannChen on 2017/5/2 11:52
 * E-mail:Q8622268@foxmail.com
</pre> *
 */
class RecommendEntity : BaseEntity() {

    var type: String? = null
    var image: String? = null
    var title: String? = null
    var people: String? = null
    var clasTime: String? = null

    override fun toString(): String {
        return "RecommendEntity{" +
                "type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", people='" + people + '\'' +
                ", clasTime='" + clasTime + '\'' +
                '}'
    }


}
