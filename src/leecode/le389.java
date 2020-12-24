package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le389
 * @date 2020/12/18 0018上午 10:30
 * @description: TODO
 */
public class le389 {

    public char findTheDifference(String s, String t) {
        int len = 0;
        for (char c : s.toCharArray()) {
            len = len ^ c;
        }
        for (char c : t.toCharArray()) {
            len = len ^ c;
        }
        return (char) len;
    }


    @Test
    public void t() {
        findTheDifference("abcd", "abcde");
    }
}
