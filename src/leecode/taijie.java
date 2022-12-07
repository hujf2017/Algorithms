package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/9 13:54
 * @Description TODO   走1  2  3步
 */
public class taijie {
    public int findway(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 1 + findway(n - 1) + findway(n - 2);
        }
        return findway(n - 1) + findway(n - 2) + findway(n - 3);
    }

    @Test
    public void t(){
        System.out.println(findway(4));
    }

}
