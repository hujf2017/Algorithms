package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/5 14:06
 * @Description TODO
 */
public class le395 {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int[] sta = new int[26];
        Map<Character, List<Integer>> map = new HashMap();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0' - 49;
            List<Integer> orDefault = map.getOrDefault(chars[i], new ArrayList<>());
            orDefault.add(i);
            map.put(chars[i], orDefault);
            sta[num] += 1;
        }
        set.add(chars.length-1);


        Iterator<Map.Entry<Character, List<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, List<Integer>> next = iterator.next();
            if(next.getValue().size()<k){
                set.addAll(next.getValue());
            }
        }

        int len = 0;
        int start = -1;
        for (int i : set) {
            len = Math.max(len, i - start - 1);
            start = i;
        }

        return len;
    }


    @Test
    public void t() {
        longestSubstring("aaabbfjeojf" ,2
                );
    }
}
