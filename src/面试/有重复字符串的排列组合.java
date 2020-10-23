package 面试;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hujf
 * @title: 有重复字符串的排列组合
 * @date 2020/10/15 0015下午 5:14
 * @description: TODO
 */
public class 有重复字符串的排列组合 {
    static char[] sad ;
    static List a ;
    public String[] permutation(String S) {
        Set set = new HashSet<>();
        char a[] = S.toCharArray();
        sad = a;
        calc(S,0);
        return new String[10];
    }

    private void calc(String s,int i) {
    }
}
