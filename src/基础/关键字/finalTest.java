package 基础.关键字;

import java.util.Properties;

/**
 * @author Hujf
 * @title: finalTest
 * @date 2020/11/18 0018下午 5:15
 * @description: TODO
 */
public class finalTest {
    public static void main(String[] args) {
        Singleton3 a = Singleton3.get();
        Singleton3 b = Singleton3.get();
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }
}
