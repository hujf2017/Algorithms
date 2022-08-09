package 基础.数据类型;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/8 9:34
 * @Description TODO
 */
public class longMax {

    @Test
    public void te(){
        long x = Long.MAX_VALUE;
        long l = x + 1;
        System.out.println(x);
        System.out.println(l);
        long lx = (long) 1.0d*l;
        System.out.println(lx);
        long lx1 = (long) (1.0d*x + 1.0d*10);

        System.out.println(lx1-1);


        long x1 = 63288;
        long num = x1*(x1-1)/2;
        System.out.println(x1*(x1-1)/2);

        System.out.println(num);
    }
}
