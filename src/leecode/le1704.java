package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/11 9:17
 * @Description TODO
 */
public class le1704 {
    public boolean halvesAreAlike(String s) {
        boolean[] c = new boolean[128];
        c['A'] = c['E'] = c['I'] = c['O'] = c['U'] = c['a'] = c['e'] = c['i'] = c['o'] = c['u'] = true;

        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (c[chars[i]]) {
                count++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (c[chars[i]]) {
                count--;
            }
        }
        if (count == 0) {
            return true;
        }

        return false;
    }


    @Test
    public void t(){
        halvesAreAlike("textbook");
    }
}
