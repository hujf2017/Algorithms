package 比赛;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hujf
 * @title: le5543
 * @date 2020/10/18 0018上午 10:31
 * @description: TODO
 */
public class le5543 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> m = new HashMap<Character,Integer>();
        int max=-1;
        for(int i=0;i<s.length();i++){
            char x =s.charAt(i);
            if(m.containsKey(x)){
                max = Math.max(max,i-m.get(x)-1);
            }else {
                m.put(x, i);
            }
        }
       return max;
    }
    @Test
    public void t(){
        maxLengthBetweenEqualCharacters("aa");
    }
}
