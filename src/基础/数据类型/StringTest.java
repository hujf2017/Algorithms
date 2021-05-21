package 基础.数据类型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: StringTest
 * @date 2021-05-17 14:41
 * @description: TODO
 */
public class StringTest {
    public static void main(String[] args) {
        String s ="123";
        String s1 = "123";
        System.out.println(s.equals(s1));

        System.out.println(s==s1);

        String a1 = "123";
        String a2 =new String("123");
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));



    }


    public void amethod(List imp){

    }

    @Test
    public void test(){
        List arrayList = null;
//        amethod(arrayList);
//        amethod(new LinkedList());
        System.out.println(arrayList);
    }
}
