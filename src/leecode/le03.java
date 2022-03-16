package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author hujf
 * @Date 2022/3/14 16:57
 * @Description TODO
 */
public class le03 {
    public int maxInvestment(int[] product, int limit) {
        long count = 0;
        product = Arrays.stream(product).sorted().toArray();
        int len = product.length - 1;
        int max = product[len];
        int numtoal = 0;
        int m = 0;
        while (true) {
            while (max == product[len]) {
                if (m != 0 && max == 0) {
                    return (int) (count% 1000000007);
                }
                if (len == 0) {
                    product[len] = max - 1;
                    m++;
                    if(m==1) {
                        numtoal++;
                    }
                    break;
                }
                len--;
                numtoal++;

            }
            if (limit - numtoal * (max - product[len]) > 0) {
                limit = limit - numtoal * (max - product[len]);
            } else if (limit == 0) {
                count = count% 1000000007 + ((max + product[len] + 1) * numtoal * (max - product[len]) / 2) % 1000000007;
                return (int)count % 1000000007;
            } else {

                long numtoal1 = limit % numtoal;
                long level = limit / numtoal;
                long k = numtoal * (max + (max + 1 - level)) * level / 2;
                k = k + (max - level) * numtoal1;

                count = count% 1000000007 + (k) % 1000000007;
                return (int)count % 1000000007;
            }
            count = count% 1000000007 + ((max + product[len] + 1) * numtoal * (max - product[len]) / 2) % 1000000007;
            max = product[len];
        }
    }

    @Test
    public void t() {
        maxInvestment(new int[]{43877,10848,10442,48132,83395,71523,60275,39527}, 34368);
        int num = 1136786562;
    }

}
