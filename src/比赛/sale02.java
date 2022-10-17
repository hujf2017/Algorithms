package 比赛;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/12 15:53
 * @Description TODO
 */
public class sale02 {
    public int longestESR(int[] sales) {
        int[] x = new int[sales.length];
        int nx = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > 8) {
                nx++;
            }
            x[i] = nx;
        }
        //找到true大于false的天数区间
        int max = 0;
        for (int i = 0; i < sales.length; i++) {
            int count = sales[i] > 8 ? 1 : 0;
            for (int j = i ; j < sales.length; j++) {
                int tian = j - i + 1;
                int trus = x[j] - x[i] +count;
                int flase = tian - trus;
                if (trus > flase) {
                    max = Math.max(max, tian);
                }
            }
        }


        return max;

    }


    @Test
    public void t() {
        longestESR(new int[]{6, 6, 9});
    }
}
