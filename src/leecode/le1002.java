package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hujf
 * @title: le1002
 * @date 2020/10/14 0014上午 11:58
 * @description: TODO
 */
public class le1002 {
    int a[] = new int[26];

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        int count = 0;
        List<String> sad = new ArrayList();

        for (String s : A) {
            if(count==0) {
                for (int i = 0; i < s.length(); i++) {
                    char ax = s.charAt(i);
                    a[ax - 97] += 1;
                    count = 1;
                }
            }else {
                int b[] = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    char ax = s.charAt(i);
                    b[ax-97]+=1;
                }
                for(int i=0;i<26;i++){
                    a[i] = Math.min(a[i], b[i]);
                }
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<a[i];j++){
                char a = (char) (i+97);
                sad.add(String.valueOf(a));
            }
        }
        return sad;
    }

    @Test
    public void test() {
        char asad = 'a';
        int xm = asad - 96;
        System.out.println(xm);

        commonChars(new String[]{"cool","lock","cook"});
    }
}
