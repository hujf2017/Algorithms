package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/30 11:06
 * @Description TODO
 */
public class le67 {
    public String addBinary(String a, String b) {
        char[] source;
        char[] chars;
        StringBuilder stringBuilder = new StringBuilder(b);
        StringBuilder stringBuilder2 = new StringBuilder(a);

        if (b.length() > a.length()) {
            source = stringBuilder.reverse().toString().toCharArray();
            chars = stringBuilder2.reverse().toString().toCharArray();
        } else {
            source = stringBuilder2.reverse().toString().toCharArray();
            chars = stringBuilder.reverse().toString().toCharArray();
        }
        char last = 0;
        for (int i = 0; i < source.length; i++) {
            int num;
            if (i >= chars.length) {
                num = source[i] + last - 48;
            } else {
                num = source[i] + chars[i] + last - 96;
            }

            if (num == 3) {
                last = 1;
                source[i] = '1';
            } else if (num == 2) {
                last = 1;
                source[i] = '0';
            } else if (num == 1) {
                last = 0;
                source[i] = '1';
            } else {
                last = 0;
                source[i] = '0';
            }
        }
        String s = String.valueOf(source);
        if (last == 1) {
            s = s + "1";
        }
        StringBuilder sbd = new StringBuilder(s);
        return sbd.reverse().toString();
    }

    @Test
    public void t() {
        System.out.println(addBinary2("1010", "1011"));
    }

    public String addBinary2(String a, String b) {
        char[] source;
        char[] chars;
        if (b.length() > a.length()) {
            source = b.toCharArray();
            chars = a.toCharArray();
        } else {
            source = a.toCharArray();
            chars = b.toCharArray();
        }
        char last = 0;
        for (int i = 0; i < source.length; i++) {
            int num = source[source.length-1-i] + last - 48;
            if (chars.length - 1 >= i) {
                num += chars[chars.length - 1-i] - 48;
            }
            if (num == 3) {
                last = 1;
                source[source.length-1-i]  = '1';
            } else if (num == 2) {
                last = 1;
                source[source.length-1-i]  = '0';
            } else if (num == 1) {
                last = 0;
                source[source.length-1-i] = '1';
            } else {
                last = 0;
                source[source.length-1-i]  = '0';
            }
        }
        String s = String.valueOf(source);
        if (last == 1) {
            s = "1" + s;
        }
        return s;
    }

}
