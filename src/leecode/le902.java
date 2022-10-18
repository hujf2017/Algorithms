package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/18 9:17
 * @Description TODO
 */
public class le902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = digits.length;
        int count = 1;
        String s = String.valueOf(n);
        int sum = 0;
        while (count < s.length()) {
            sum += Math.pow(len, count);
            count++;
        }

        sum += dfs(digits, 0, s);
        return sum;

    }

    private int dfs(String[] digits, int i, String s) {
        if(i==s.length()){
            return 1;
        }
        int count = 0;
        char cx = s.charAt(i);
        //判断每个dig
        for (String d : digits) {
            if (d.charAt(0) < cx) {
                count += (int) Math.pow(digits.length, s.length() - 1 - i);
            } else if (d.charAt(0) > cx) {
                return count;
            } else {
                count += dfs(digits, i + 1, s);
            }
        }

        return count;
    }


    @Test
    public void t() {
        atMostNGivenDigitSet(new String[]{"1","4","9"}, 762589867);
    }
}
