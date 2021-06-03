package 基础.反射和动态代理;

import javax.jws.Oneway;
import java.lang.reflect.Field;

/**
 * @author Hujf
 * @title: TestClass
 * @date 2021-06-03 17:11
 * @description: TODO
 */
public class TestClass {
    public static void main(String[] args) {
        user o = new user();
        o.setNum1("1");
        o.setNum2("2");
        Class<?> clazz = o.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field:declaredFields){
            field.setAccessible(true);
            try {
                String key =field.getName();
                String o1 = (String) field.get(o);
                System.out.println(key+" "+o1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
