package com.itheima.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID()
    {
       return UUID.randomUUID().toString();//得到随机的一个字符串
    }

}
