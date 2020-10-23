package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le459
 * @date 2020/9/25 0025上午 10:23
 * @description: TODO
 */
public class le459 {
    @Test
    public void repeatedSubstringPattern() {
        String s = "abab";
        String patter = "";
        for (int i = 0; i < s.length() - 1; i++) {
            patter = patter + s.substring(i, i + 1);
            String sx = calc(s, patter);
            if ("".equals(sx)) {
                return;
            }
        }
        return;
    }

    private String calc(String s, String patter) {
        if (s.startsWith(patter)) {
            s = calc(s.substring(patter.length()), patter);
        }

        return s;
    }


    @Test
    public void repeatedSubstringPattern2() {
        String s = "abab";
        int n = s.length();
        //至少有两个的意思
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return;
                }

            }
        }
    }


    @Test
    public void repeatedSubstringPattern3() {
        String s = "abab";
        int a =(s + s+s).indexOf(s, 1);
        System.out.println(a);
    }

}
