package leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/8/4 9:24
 * @Description TODO
 */
public class le433 {

    public int minMutation(String start, String end, String[] bank) {
        //找到start  和 end的 区别
        char[] chars = start.toCharArray();
        char[] chars1 = end.toCharArray();
        Set <Integer>set = new HashSet();
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=chars1[i]){
                set.add(i);
            }
        }

        List<Set<Integer>> list = new ArrayList<>();

        for(String s:bank){
            char[] chars2 = s.toCharArray();
            Set <Integer>set2 = new HashSet();
            for(int i=0;i<chars.length;i++){
                if(chars[i]!=chars2[i]){
                    set2.add(i);
                }
            }
            list.add(set2);
        }

        if(set.size()==0){
            return 0;
        }

        while (set.size()>0){
            for(Set set1:list){
               if(set1.size()==1) {
                   dfs(set1);
               }
            }
        }
        return 0;
    }

    private void dfs(Set set1) {
    }
}
