package com.EvanMao.LiveList.SQL;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2016/1/15.
 */
public class Sql_MainCardList extends DataSupport {

    private String card_name;
    private int card_type;

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }


}
