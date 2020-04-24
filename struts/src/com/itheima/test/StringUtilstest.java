package com.itheima.test;

import org.apache.commons.lang3.StringUtils;

public class StringUtilstest {
       public static void main(String[] args) {
           String s1 = null;
           String s2 = "";
           String s3 = "  ";
           //该方法验证字符串是否为null或者空字符串，但是不会去除空格
           System.out.println(StringUtils.isEmpty(s1));
           System.out.println(StringUtils.isEmpty(s2));
           System.out.println(StringUtils.isEmpty(s3));
           //该方法验证字符串是否为null或者空字符串，但是会去除空格
           System.out.println(StringUtils.isBlank(s1));
           System.out.println(StringUtils.isBlank(s2));
           System.out.println(StringUtils.isBlank(s3));

    }

}
