package com.crab.utils;

import com.crab.entity.Admin;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Little_Crab
 * @date 2021/4/12 15:46
 */
public class SessionUtils {
    private static final String key = "admin";

    public static void setAdmin(HttpServletRequest request, Admin admin) {
        request.getSession().setAttribute(key, admin);
    }

    public static Admin getAdmin(HttpServletRequest request) {
        if (request.getSession().getAttribute(key) != null) {
            return (Admin) request.getSession().getAttribute(key);
        } else {
            return null;
        }
    }
}
