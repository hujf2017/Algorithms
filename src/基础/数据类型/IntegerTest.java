package 基础.数据类型;

/**
 * @author Hujf
 * @title: IntegerTest
 * @date 2021-05-17 14:32
 * @description: TODO
 */
public class IntegerTest {

    public static void main(String[] args) {
        int a1 = 1;
        Integer a2= 1;
        System.out.println(a1==a2);

        int b1 =128;
        Integer b2 =128;
        System.out.println(b1==b2);

        Integer c1 =128;
        Integer c2 =128;
        System.out.println(c1.equals(c2));
        //用==报错 包装类型间的相等判断应该用equals，而不是'=='
        //mingm System.out.println(c1==c2);

    }
}
