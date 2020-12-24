package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le387
 * @date 2020/12/23 0023下午 4:36
 * @description: TODO
 */
public class le387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m = new HashMap(10);
        char []ch =s.toCharArray();

        for(int i=0;i<ch.length;i++){
            m.put(ch[i],m.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < ch.length; i++) {
            if (m.get(ch[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}




class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
