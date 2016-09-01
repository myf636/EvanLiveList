package com.EvanMao.LiveList.InComeActivity;

/**
 * Created by Meict on 2016/9/1.
 */
public interface IIncomePresenter {
    /**
     * 点击了列表项，跳转到响应的详情
     *
     * @param style 0:收支列表
     *              1：信用卡
     * @param id    对应的id
     */
     void ShowInfo(int style, int id);

    /**
     * 点击了更多或者管理，跳到列表
     *
     * @param style 0：收支列表
     *              1：信用卡
     */
     void ShowList(int style);
}
