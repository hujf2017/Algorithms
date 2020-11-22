package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le242
 * @date 2020/11/22 0022上午 10:21
 * @description: TODO
 */
public class le242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char []a = s.toCharArray();
        Arrays.sort(a);
        char []b = t.toCharArray();
        Arrays.sort(b);
        for(int i=0;i<s.length();i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }


}
