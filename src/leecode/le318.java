package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/10/17 11:49
 * @Description TODO
 */
public class le318 {
    public int maxProduct(String[] words) {
        int amx = 0;
        Map<String,Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set <Integer>set = new HashSet();
            for(int j=0;j<words[i].length();j++){
                set.add(words[i].charAt(j)-'a') ;
            }
            map.put(words[i],set);
        }
        return amx;

    }

    private boolean calc(String word, String word1) {
        int []ins = new int[26];
        for(int i=0;i<word.length();i++){
            ins[word.charAt(i)-'a'] =1;
        }
        for(int i=0;i<word1.length();i++){
            if(ins[word1.charAt(i)-'a'] ==1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void t(){
        maxProduct(new String[]{"abcw","xtfn"});
    }
}
