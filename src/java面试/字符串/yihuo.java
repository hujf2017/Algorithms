package java面试.字符串;

/**
 * @Author hujf
 * @Date 2022/7/29 16:22
 * @Description
 */
public class yihuo {
    public static void main(String[] args) {
        String a1 = "123";
        int len= a1.length();
        String a = "123456";
        a1 = "123"+"456";
        System.out.println( a.equals(a1));
        System.out.println( a==a1);
        System.out.println( 6==len);

        System.out.println( a1.length()==a.length());
    }
}
