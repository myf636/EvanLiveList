package com.EvanMao.LiveList.fragment;

import android.util.SparseArray;

import com.EvanMao.LiveList.EvanApp;
import com.EvanMao.LiveList.card.InComeCard;
import com.EvanMao.LiveList.card.MemberCard;
import com.EvanMao.LiveList.card.TimeManagerCard;
import com.EvanMao.LiveList.R;
import com.EvanMao.LiveList.SQL.Sql_MainCardList;
import com.EvanMao.Tool.UIFragmentControl;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/14.
 */
public class MainModel implements IMainModel {
    @Override
    public SparseArray<UIFragmentControl> getDefaltMainViewInfo() {
        SparseArray<UIFragmentControl> sparseArray = new SparseArray<>();
        List<Sql_MainCardList> lists;
        if (DataSupport.count(Sql_MainCardList.class) > 0) {
            //大于0，说明存储过
            lists = DataSupport.findAll(Sql_MainCardList.class);
        } else {
            lists = new ArrayList<>();
            String[] defaltArray = EvanApp.getInstance().getResources().getStringArray(R.array.main_card);
            for (int i = 0; i < defaltArray.length; i++) {
                Sql_MainCardList sql_mainCardList_1 = new Sql_MainCardList();
                sql_mainCardList_1.setCard_name(defaltArray[i]);
                sql_mainCardList_1.setCard_index(i);
                sql_mainCardList_1.setCard_type(i);
                lists.add(i, sql_mainCardList_1);
            }
            DataSupport.saveAll(lists);
        }
        for (int i = 0; i < lists.size(); i++) {
            switch (lists.get(i).getCard_type()) {
                case 0:
                    //收支卡
                    sparseArray.put(lists.get(i).getCard_index(), InComeCard.newInstance(null, null));
                    break;
                case 1:
                    //时间卡
                    sparseArray.put(lists.get(i).getCard_index(), TimeManagerCard.newInstance(null, null));
                    break;
                case 2:
                    //成员卡
                    sparseArray.put(lists.get(i).getCard_index(), MemberCard.newInstance(null, null));
                    break;
                default:
                    break;
            }
        }
        return sparseArray;
    }
}
