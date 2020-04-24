package com.itheima.web.converter;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 需求：
 *    把mm/dd/yyyy格式的数据转成日期类型
 *    把数据库中本地日期格式转成MM/dd/yyyy输出
 * 自定义子类转换器：
 * 第一步：编写一个类，继承自StrutsTypeConverter,实现这俩个抽象方法
 *
 * 用法：
 *   如果是局部类型转换，就在该类的包下面写一个properties文件，并且以该javabean的名称加上 -conversion.properties命名
 *   其内容为javabean的属性作为key,类型转换器的全类名作为value
 *   如：birthday=com.itheima.web.converter.MyTypeConverter
 */

public class MyTypeConvertor extends StrutsTypeConverter {

    /**
     * 把字符串数组中的数据转换成日期类型
     * @param map 也叫context，是OGNL的上下文对象，暂时不用
     * @param strings  要转换的数据
     * @param aClass  目标类型
     * @return
     */
    private DateFormat format=new SimpleDateFormat("MM/dd/yyyy");
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        //1.先看看有没有数据
           if(strings==null||strings.length==0)
           {
               return null;
           }
        //2.取出数组的第一个元素
          String date=strings[0];

        //3.判断目标类型的字节码是不是日期类型
          if(aClass == Date.class) {
              //4.使用DateFormat进行转换，并且返回转换后的结果
              try {
                  return   format.parse(date);
              } catch (ParseException e) {
                  e.printStackTrace();
                  return null;
              }
          }
        return null;
    }

    /**
     * 把日期类型数据转换成字符串类型
     *
     * @param map
     * @param o
     * @return
     */
    @Override
    public String convertToString(Map map, Object o) {
       //1.判断o是否是日期类型
        if (o instanceof Date) {
            //2.是的话就使用转换器转换成指定格式的字符串并返回
           Date date= (Date)o;
          return format.format(date);
        }
        return null;
    }
}
