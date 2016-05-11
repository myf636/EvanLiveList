package com.EvanMao.LiveList.MainActivity;

import com.EvanMao.LiveList.fragment.IMainModel;
import com.EvanMao.LiveList.fragment.MainModel;

/**
 * Created by Administrator on 2016/1/14.
 */
public class MainViewPresenter implements IMainViewPresenter {

    private IMainView mainView;
    private IMainModel mainModel;

    public MainViewPresenter(IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }

    @Override
    public void ShowMainView() {
        mainView.setDefaultView();
    }

    @Override
    public void Turn2NextView() {

    }

    @Override
    public void Turn2NextViewAllow2Back() {

    }
}
