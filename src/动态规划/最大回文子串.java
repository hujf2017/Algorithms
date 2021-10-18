package 动态规划;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 最大回文子串
 * @date 2021-10-18 15:00
 * @description: TODO
 */
public class 最大回文子串 {

    @Test
    public void test() {
        System.out.println(find("135537"));
    }

    public String  find(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int strLen  = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for(int i=0;i<strLen;i++){
            left = i-1;
            right = i+1;
            while(left >= 0 && s.charAt(left) == s.charAt(i)){
                len++;
                left --;
            }

            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while(left >=0&&right < strLen && s.charAt(right) == s.charAt(left)){
                len = len + 2;
                left--;
                right++;
            }

            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len =1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
