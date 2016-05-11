package com.EvanMao.LiveList.fragment;

/**
 * Created by Administrator on 2016/1/20.
 */
public class Fragment_presenter implements IFragment_presenter {
    private IMainFragmentView mainFragmentView;
    private IMainModel mainModel;

    public Fragment_presenter(IMainFragmentView mainFragmentView) {
        this.mainFragmentView = mainFragmentView;
        mainModel = new MainModel();
    }

    @Override
    public void setPandectView() {
        mainFragmentView.ShowMainView(mainModel.getDefaltMainViewInfo());
    }

    @Override
    public void setInComeView() {

    }

    @Override
    public void setMemberView() {

    }

    @Override
    public void setTimeView() {

    }
}
