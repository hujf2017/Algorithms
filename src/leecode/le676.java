package leecode;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author hujf
 * @Date 2022/7/11 10:53
 * @Description TODO
 */
public class le676 {

    Map<Integer, Set> map = new HashMap<>();
    public le676() {
    }
    public void buildDict(String[] dictionary) {
        //对所有的dic 单词作正则匹配
        for(String s :dictionary){
            Set set = map.getOrDefault(s.length(),new HashSet());
            set.add(s);
            map.put(s.length(),set);
        }
    }
    public boolean search(String searchWord) {
        Set<String> set = map.get(searchWord.length());
        if(set==null){
            return false;
        }
        char[] chars = searchWord.toCharArray();
        for(String s:set){
            int count =0;
            int len =0;
            char[] chars1 = s.toCharArray();
            while(count<searchWord.length()){
                int i = chars[count];
                int i1 = chars1[count];
                if(i!=i1){
                    len++;
                    if(len>2){
                        break;
                    }
                }
                count++;
            }

            if(len==1){
                return true;
            }
        }
        return false;
    }

    @Test
    public void t(){
//        String s =".*ello";
//        boolean hello = Pattern.matches(s, "hello");
//        System.out.println();

        le676 le6762 = new le676();
        le6762.buildDict(new String[]{"hello","leetcode"});
        System.out.println(le6762.search("hell1"));
        System.out.println(le6762.search("hello"));
        System.out.println(le6762.search("le"));
    }
}
