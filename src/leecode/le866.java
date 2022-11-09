package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/2 15:22
 * @Description TODO
 */
public class le866 {
    public int primePalindrome(int n) {
        int x = 200000000;
        StringBuilder sbd = new StringBuilder(String.valueOf(n));
        if (isPram(n) && sbd.toString().equals(sbd.reverse().toString())) {
            return n;
        }
        while (n <= x) {
            n = buildNext(n);
            if (isPram(n)) {
                return n;
            }
        }
        return 0;
    }

    private int buildNext(int n) {
        String s = String.valueOf(n);

        if (s.length() % 2 == 0) {
            String substring = s.substring(0, s.length() / 2);
            String substring2 = s.substring(s.length() / 2);
            while (true) {
                int num = Integer.valueOf(substring);
                String s1 = String.valueOf(num + 1);
                String reverse = new StringBuilder(s1).reverse().toString();

                int numx = Integer.valueOf(substring2);
                String s2 = String.valueOf(numx + 1);
                String reversex = new StringBuilder(s2).reverse().toString();


                int num2;
                int numsx;
                if (s1.length() > substring.length()) {
                    num2 = Integer.valueOf(s1 + reverse.substring(1));
                } else {
                    num2 = Integer.valueOf(s1 + reverse);
                }

                if (s2.length() > substring2.length()) {
                    numsx = Integer.valueOf(reversex + s2);
                } else {
                    numsx = Integer.valueOf(s2 + reversex);
                }

                if (numsx >= n) {
                    return Math.min(num2,numsx);
                }
                return num2;

            }
        } else {
            String substring = s.substring(0, s.length() / 2 + 1);
            String substring2 = s.substring(s.length() / 2);
            while (true) {
                int num = Integer.valueOf(substring);
                String s1 = String.valueOf(num + 1);
                String reverse = new StringBuilder(s1).reverse().toString();
                int num2;
                int numsx;

                if (s1.length() > substring.length()) {
                    num2 = Integer.valueOf(s1.substring(0, s1.length() - 1) + reverse.substring(1));
                } else {
                    num2 = Integer.valueOf(s1 + reverse.substring(1));
                }

                int numx = Integer.valueOf(substring2);
                String s2 = String.valueOf(numx + 1);
                String reversex = new StringBuilder(s2).reverse().toString();

                if (s2.length() > substring2.length()) {
                    numsx = Integer.valueOf(reversex + s2);
                } else {
                    numsx = Integer.valueOf(s2 + reversex);
                }

                if (num2 >= n) {
                    return num2;
                }
            }
        }
    }

    private boolean isPram(int N) {
        if (N < 2) {
            return false;
        }
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            if (N % d == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        System.out.println(primePalindrome(98799999
        ));
    }
}
