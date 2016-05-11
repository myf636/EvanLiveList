package com.EvanMao.LiveList.fragment;

import android.content.Intent;
import android.util.SparseArray;

import com.EvanMao.Tool.UIFragmentControl;

/**
 * Created by Administrator on 2016/1/20.
 */
public interface IMainFragmentView {
    void ShowMainView(SparseArray<UIFragmentControl> sparseArray);

    void Turn2Next(Intent it);
}
