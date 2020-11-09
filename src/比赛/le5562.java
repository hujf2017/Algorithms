package 比赛;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le5562
 * @date 2020/11/8 0008上午 11:00
 * @description: TODO
 */
public class le5562 {
    public int minDeletions(String s) {
        Map<Character,Integer> m = new HashMap<>();
        char[] a= s.toCharArray();
        for(char c:a){
            if(m.containsKey(c)){
                m.put(c,m.get(c)+1);
            }else{
                m.put(c,1);
            }
        }
        Set set = new HashSet<>();
        List needCut = new ArrayList();
        for(Map.Entry entry: m.entrySet()){
           int ax = (int) entry.getValue();
           if(set.contains(ax)){
               needCut.add(ax);
           }else{
               set.add(ax);
           }
        }
        int total=0;
        Iterator<Integer> it = needCut.iterator();
        while(it.hasNext()){
            int ssa =it.next();
            int count=0;
            for(int i=ssa-1;i>=0;i--){
                count++;
                if(i==0||!set.contains(i)){
                    set.add(i);
                    total+=count;
                    break;
                }
            }
        }
        return total;
    }

    @Test
    public void t(){
        minDeletions("bbcebab");
    }
}
