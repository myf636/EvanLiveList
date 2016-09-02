package com.EvanMao.LiveList.InComePage;

/**
 * Created by Meict on 2016/9/1.
 */
public class IncomePresenter implements IIncomePresenter {
    private IInComeView inComeView;
    private IIncomeModel incomeModel;

    /**
     * 实例化，获取到view和model的接口
     * @param inComeView
     */
    public IncomePresenter(IInComeView inComeView) {
        this.inComeView = inComeView;
        incomeModel = new IncomeModel();
    }

    /**
     * @param style 0:收支列表
     *              1：信用卡
     * @param id    对应的id
     */
    @Override
    public void ShowInfo(int style, int id) {

    }

    /**
     * @param style 0：收支列表
     */
    @Override
    public void ShowList(int style) {

    }
}
