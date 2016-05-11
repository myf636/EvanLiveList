package com.EvanMao.LiveList.MainActivity;

import android.content.Intent;

/**
 * Created by Administrator on 2016/1/14.
 */
public interface IMainViewPresenter {

    void ShowMainView();

    /**
     * 跳转到其他页面
     */
    void Turn2NextView();

    /**
     * 能跳回的
     */
    void Turn2NextViewAllow2Back();
}
