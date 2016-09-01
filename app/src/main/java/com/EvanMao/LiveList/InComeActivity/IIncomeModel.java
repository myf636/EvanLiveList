package com.EvanMao.LiveList.InComeActivity;

import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by Meict on 2016/9/1.
 */
public interface IIncomeModel {
    /**
     * 获取收支列表 最多5条
     */
    ArrayList<SparseArray<String>> getIncomeList(int limit);

    /**
     * 获取信用卡信息 最多5条
     */
    ArrayList<SparseArray<String>> getCardList(int limit);

    /**
     * 获取理财信息 不限
     */
    ArrayList<SparseArray<String>> getManageMoneyList();
}
