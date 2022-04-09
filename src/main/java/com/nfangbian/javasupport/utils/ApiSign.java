package com.nfangbian.javasupport.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ApiSign {
    // 密钥
    private String secret;
    //要签名的数据
    protected Map<String, Object> data;

    public static ApiSign getInstance() {
        return new ApiSign();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String makeSign() {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray); // 排序
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k!="sign"
                    && data.get(k) != null
                    && data.get(k) != ""
                    && !data.get(k).equals(false)
                    && !data.get(k).equals(0)
                    && !data.get(k).equals(0.0)
                    && !data.get(k).getClass().isArray() ) {
                if(data.get(k).equals(true)) {
                    sb.append(k).append("=").append(1).append("&");
                } else {
                    sb.append(k).append("=").append(data.get(k)).append("&");
                }

            }
        }

        sb.append("key=").append(secret);
        String result = MD5Util.Md5V1(sb.toString()).toUpperCase();
        return result;
    }

}
