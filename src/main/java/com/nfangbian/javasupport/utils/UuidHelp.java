package com.nfangbian.javasupport.utils;

import java.util.Date;
import java.util.UUID;

public class UuidHelp {

    public static long generateUuid() {
        UUID uuid = UUID.randomUUID();
        long bits = uuid.getMostSignificantBits();
        if (bits < 0)
        {
            return -bits;
        }
        return bits;
    }

    // 32位md5唯一值
    public static String getUuid() {
        Long l = UuidHelp.generateUuid();
        Date d = new Date();
        String str = MD5Util.Md5V1(Long.toString(l) + Long.toString(d.getTime()));
        return str;
    }

}
