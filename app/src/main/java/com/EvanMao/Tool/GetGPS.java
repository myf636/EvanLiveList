package com.EvanMao.Tool;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2015/7/15.
 */
public class GetGPS extends ContextWrapper {
    public GetGPS(Context base) {
        super(base);
    }

    static GetGPS instance;

    public static GetGPS getInstance(Context base) {
        if (instance == null)
            instance = new GetGPS(base);
        return instance;
    }

    public LocationManager lm;

    /**
     * 获取城市名称
     * @return
     * @throws IOException
     */
    public String getCity() throws IOException {
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //判断GPS是否正常启动
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(getApplicationContext(), 0, GPSIntent, 0).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }


        //为获取地理位置信息时设置查询条件
        String bestProvider = lm.getBestProvider(getCriteria(), true);
        //获取位置信息
        //如果不设置查询要求，getLastKnownLocation方法传人的参数为LocationManager.GPS_PROVIDER
        Location location = lm.getLastKnownLocation(bestProvider);
//        Location location= lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        double a = location.getLatitude();
        double b = location.getLongitude();
        return getCitybyNum(a, b);
    }

    /**
     * 通过坐标获取城市名称
     * @param latitude
     * @param longitude
     * @return
     * @throws IOException
     */
    private String getCitybyNum(double latitude, double longitude) throws IOException {
        String strReturnUrl = "0";

        int verCode = 1;

        StringBuilder Url = new StringBuilder();
        Url.append("http://api.map.baidu.com/geocoder?");
        Url.append("location=" + latitude + "," + longitude);
        Url.append("&output=xml&key=jep5n72TC0tlur4vZvC0SR2o");

        //
        URL myurl = new URL(Url.toString());
        HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
        conn.setDoInput(true);
        //
        conn.setConnectTimeout(1000 * 30);
        conn.setReadTimeout(1000 * 30);
        //
        conn.setRequestMethod("GET");
        //
        conn.connect();
        //

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        String lines;
        StringBuilder retlines = new StringBuilder();
        while ((lines = reader.readLine()) != null) {
            retlines.append(lines);
        }
        //

        String matchCodeFlagStart = "<city>";
        String matchCodeFlagStop = "</city>";
        int iStart = -1;
        int iStop = 0;
        int iValueStart = 0;

        iStart = retlines.indexOf(matchCodeFlagStart, iStop);
        if (iStart >= 0)
            iStop = retlines.indexOf(matchCodeFlagStop, iStart);
        if (iStart >= 0 && iStop > iStart) {
            iValueStart = iStart + matchCodeFlagStart.length();
            strReturnUrl = (retlines.substring(iValueStart, iValueStart
                    + (iStop - iValueStart)));
        }
        //
        reader.close();
        //
        conn.disconnect();
        //
        return strReturnUrl;


    }

    private Criteria getCriteria() {
        Criteria criteria = new Criteria();
        //设置定位精确度 Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精细
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        //设置是否要求速度
        criteria.setSpeedRequired(false);
        // 设置是否允许运营商收费
        criteria.setCostAllowed(false);
        //设置是否需要方位信息
        criteria.setBearingRequired(false);
        //设置是否需要海拔信息
        criteria.setAltitudeRequired(false);
        // 设置对电源的需求
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return criteria;
    }
}
