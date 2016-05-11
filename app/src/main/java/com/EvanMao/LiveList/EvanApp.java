package com.EvanMao.LiveList;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

import java.io.File;

/**
 * Created by Administrator on 2016/1/14.
 */
public class EvanApp extends LitePalApplication {

    static EvanApp instance;

    public static EvanApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SQLiteDatabase db = Connector.getDatabase();


    }

    /**
     * 判断SD卡是否存在
     *
     * @return
     */
    public boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建文件路径
     *
     * @return
     */
    public String ExFilesPath() {
        File dir = new File(this.getApplicationInfo().dataDir + "/Insurance/");
        if (!dir.exists())
            dir.mkdir();
        //
        return dir.getAbsolutePath();
    }

    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) {// 全角空格为12288，半角空格为32
                c[i] = (char) 12288;
                continue;
            }
            if (c[i] > 33 && c[i] < 126)// 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }
}
