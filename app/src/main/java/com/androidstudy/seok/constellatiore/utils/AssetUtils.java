package com.androidstudy.seok.constellatiore.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.androidstudy.seok.constellatiore.MainActivity;
import com.androidstudy.seok.constellatiore.bean.StarInfoBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: seok hzl
 * @date: 2021/12/29
 */
public class AssetUtils {
    private static Map<String, Bitmap> logoImgMap;
    private static Map<String, Bitmap> contentImgMap;


    public static String getJsonFromAssets(Context context, String fileName) {
        //获取assets管理器
        AssetManager assets = context.getResources().getAssets();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //获取输入流
        InputStream is;
        try {
            is = assets.open(fileName);
            int len;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            String msg = bos.toString();
            is.close();
            bos.close();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Bitmap getBitmapFromAssets(Context context, String fileName) {
        Bitmap bitmap = null;
        //获取文件管理器
        AssetManager assets = context.getResources().getAssets();
        InputStream open;
        try {
            open = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static void saveBitmapFromAssets(Context context, StarInfoBean infoBean) {
        logoImgMap = new HashMap<>();
        contentImgMap = new HashMap<>();
        List<StarInfoBean.StarinfoBean> starList = infoBean.getStarinfo();
        for (int i = 0; i < starList.size(); i++) {
            String logoName = starList.get(i).getLogoname();
            String fileName = "xzlogo/" + logoName + ".png";
            Bitmap logoBm = getBitmapFromAssets(context, fileName);
            logoImgMap.put(logoName, logoBm);

            String contentName = "xzcontentlogo/" + logoName + ".png";
            Bitmap bitmap = getBitmapFromAssets(context, contentName);
            contentImgMap.put(logoName, bitmap);
        }

    }

    public static Map<String, Bitmap> getLogoImgMap() {
        return logoImgMap;
    }

    public static Map<String, Bitmap> getContentImgMap() {
        return contentImgMap;
    }
}
