package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le191
 * @date 2021/3/228:10
 * @description:
 *
 * 0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
 *
 * 0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
 *
 * 0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
 *
 * 0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)
 *
 * 0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
 *
 * 0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
 * ————————————————
 * 版权声明：本文为CSDN博主「zhusf16」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/u012604810/article/details/80623241
 *
 */
public class le191 {
    @Test
    public void t(){
        hammingWeight(00000000000000000000000000001011);
    }


    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       // return   le191.bitCount(n);

        int cnt = 0;
        while(n!=0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }


    public static int bitCount(int i) {
        // HD, Figure 5-2
        int s = i >>> 1;
        int s1 = s& 0x55555555;
        i = i - s1;
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
