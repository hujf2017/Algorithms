package leecode;

/**
 * @author Hujf
 * @title: le342
 * @date 2020/10/15 0015下午 5:22
 * @description: TODO
 */
public class le342 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
