package com.androidstudy.seok.constellatiore.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: seok hzl
 * @date: 2022/1/13
 */
public class HttpUtil {
    private static String result = "";


    public static String sendGet(String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).run();
        return result;
    }
}
