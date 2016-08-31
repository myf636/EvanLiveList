package com.EvanMao.LiveList.fragment;

import android.content.Intent;
import android.util.SparseArray;

import com.EvanMao.Tool.UIFragmentControl;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/20.
 */
public interface IMainFragmentView {
    void ShowMainView(ArrayList<UIFragmentControl> sparseArray);

    void Turn2Next(Intent it);
}
