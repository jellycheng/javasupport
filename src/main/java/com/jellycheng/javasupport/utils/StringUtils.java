package com.jellycheng.javasupport.utils;

public class StringUtils {

    public static String toStringIgnoreNull(Object o) {
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    public static String toStringNotIgnoreNull(Object o) {
        if (o == null) {
            return null;
        }
        return o.toString();
    }

    /**
     * 布尔值转换为0或1
     *
     * @param bool bool值
     * @return String
     *
     */
    public static String boolean2String(Boolean bool) {
        if (bool == null) {
            return null;
        } else if (bool) {
            return "1";
        } else {
            return "0";
        }
    }

    public static Boolean string2Boolean(String bool) {
        if("1".equals(bool)) {
            return true;
        } else {
            return false;
        }
    }

}
