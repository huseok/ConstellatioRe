package com.androidstudy.seok.constellatiore.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: seok hzl
 * @date: 2022/1/13
 */
public class URLContentUtil {
    //星座配对接口

    public static String getParnterURL(String man, String woman) {
        man = man.replace("座", "");
        woman = woman.replace("座", "");
        return "http://apis.juhe.cn/xzpd/query?key=" + StaticUtils.XZPD_KEY + "&men=" + man + "&women=" + woman;
    }

    //星座运势配对接口
    public static String getLuckURL(String name) {
        return "http://web.juhe.cn:8080/constellation/getAll?key=" + StaticUtils.XZYS_KEY + "&consName=" + name;
    }
}
