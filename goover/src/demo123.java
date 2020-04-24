import com.itheima.Domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class demo123 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user=new User();
        Map map=new HashMap();
        map.put("username","tom");
        map.put("password","123");
        map.put("email","tom@163.com");
        map.put("birthday","2019-12-23");
        System.out.println(map);

        ConvertUtils.register(new Converter() {//注册一个日期转换器

                                  public Object convert(Class type, Object value) {
                                      Date date1 =null;
                                      if(value instanceof String){
                                          String date = (String) value;
                                          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                          try {
                                              date1 = sdf.parse(date);
                                          } catch (ParseException e) {
                                              e.printStackTrace();
                                          }
                                      }
                                      return date1;
                                  }
                              }
                ,Date.class);
        BeanUtils.populate(user,map);

    }
}
