import itcast.reflect.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.LocaleConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;


import java.time.LocalDate;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class demo12 {
    @Test
    public void test1() throws Exception{
        Map map = new HashMap();
        map.put("name", "xiazdong");
        map.put("age", "20");
        map.put("birth", "2010-10-10");
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        Person p = new Person();
        BeanUtils.populate(p, map);
        System.out.println(p.getAge());
        System.out.println(p.getBirth().toLocaleString());


    }
}
