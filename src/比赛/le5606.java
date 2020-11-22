package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5606
 * @date 2020/11/22 0022上午 10:34
 * @description: TODO
 */
public class le5606 {
    StringBuffer sbf = new StringBuffer();

    public String getSmallestString(int n, int k) {
        if(k<=0){
            return sbf.toString();
        }
        int num = k - 26 * (n - 1);
        if (num > 0) {

            sbf.append((char) ('a'+num-1));
            getSmallestString(n - 1, k - num );
        } else {
            sbf.append('a');
            getSmallestString(n - 1, k - 1);
        }
        return sbf.toString();
    }

    @Test
    public void t() {
        String s =getSmallestString(5, 73);
        System.out.println(s);
    }

}
