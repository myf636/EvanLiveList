package com.EvanMao.Tool;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.EvanMao.LiveList.EvanApp;


public class UIUtils {

    public static int one2one(int px) {
        return px;
    }

    public static int dip2px(int dip) {
        int px = 0;
        //
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wMgr = (WindowManager) EvanApp.
                getInstance().getSystemService(Context.WINDOW_SERVICE);
        wMgr.getDefaultDisplay().getMetrics(dm);
        px = (int) ((float) dip * dm.density);
        //
        dm = null;
        //
        return px;
    }

    public static int px2dip(int px) {
        int dip = 0;
        //
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wMgr = (WindowManager) EvanApp.
                getInstance().getSystemService(Context.WINDOW_SERVICE);
        wMgr.getDefaultDisplay().getMetrics(dm);
        dip = (int) ((float) px / dm.density);
        //
        dm = null;
        //
        return dip;
    }

    public static int currentScreenMode() {
        int md = 0;
        //
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wMgr = (WindowManager) EvanApp.
                getInstance().getSystemService(Context.WINDOW_SERVICE);
        wMgr.getDefaultDisplay().getMetrics(dm);
        md = dm.densityDpi;
        //
        dm = null;
        //
        return md;
    }

    public static int currentScreenX() {
        int md = 0;
        //
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wMgr = (WindowManager) EvanApp.
                getInstance().getSystemService(Context.WINDOW_SERVICE);
        wMgr.getDefaultDisplay().getMetrics(dm);
        md = dm.widthPixels;
        //
        dm = null;
        //
        return md;
    }

    public static int currentScreenY() {
        int md = 0;
        //
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wMgr = (WindowManager) EvanApp.
                getInstance().getSystemService(Context.WINDOW_SERVICE);
        wMgr.getDefaultDisplay().getMetrics(dm);
        md = dm.heightPixels;
        //
        dm = null;
        //
        return md;
    }
}
