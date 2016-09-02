package com.EvanMao.LiveList.InComeActivity;

import org.litepal.crud.DataSupport;

/**
 * Created by Meict on 2016/9/2.
 */
public class InfoBean extends DataSupport {
    public String id;
    public String action;
    public String money;
    public String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
