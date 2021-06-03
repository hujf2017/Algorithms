package 基础.对象引用;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 字符串引用
 * @date 2020/11/6 0006下午 8:16
 * @description: TODO
 */
public class 字符串引用 {
    @Test
    public void test(){

        int a = 123;
        Integer a2 = new Integer(123);
        System.out.println(a==a2);

        String s ="213";
        String s1 = "213";
        String s2 = new String(s);
        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(s.equals(s2));

        String s1x = new StringBuilder("java").toString();
        String s2x = s1x.intern();
        System.out.println(s1x==s2x);

    }
}
