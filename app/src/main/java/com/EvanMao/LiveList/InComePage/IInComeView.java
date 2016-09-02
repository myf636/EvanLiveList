package com.EvanMao.LiveList.InComePage;

import android.content.Intent;

/**
 * Created by Administrator on 2016/1/15.
 */
public interface IInComeView {
    /**
     * 加载信息
     */
     void LoadInfo();


    /**
     * 跳转到下一页
     * @param it intent意图
     */
     void Jump2NextActivity(Intent it);



}
