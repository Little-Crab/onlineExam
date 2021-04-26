package com.crab.utils;

import org.springframework.util.DigestUtils;

/**
 * @author Little_Crab
 * @date 2021/4/10 22:32
 */
public class MD5Utils {
    private static final String salt = "exam*@#";

    public static String getMd5(String str) {
        String val = str + salt;
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    public static void main(String[] args) {
        String md5 = MD5Utils.getMd5("123456");
        System.out.println(md5);
    }
}
