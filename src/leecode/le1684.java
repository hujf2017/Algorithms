package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/8 10:56
 * @Description TODO
 */
public class le1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = allowed.toCharArray();
        int[] cc = new int[26];
        for (char c : chars) {
            int num = c - 'a';
            cc[num] = 1;
        }
        int cotr = 0;
        for (String s : words) {
            boolean ok = true;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 'a';
                if (cc[num] == 0) {
                    ok = false;
                    break;
                }
            }
            if(ok){
                cotr++;
            }
        }

        return cotr;
    }

    @Test
    public void main() {
        countConsistentStrings("aa", new String[]{"ac","a"});
    }
}
