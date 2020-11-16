package 比赛;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le5603
 * @date 2020/11/15 0015上午 11:16
 * @description: TODO
 */
public class le5603 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        char wc[] = word1.toCharArray();
        Map<Character,Integer> a = new HashMap<>();
        for(int i=0;i<wc.length;i++){
            if(a.containsKey(wc[i])){
                a.put(wc[i],a.get(wc[i])+1);
            }else{
                a.put(wc[i],1);
            }
        }
        List ax = new ArrayList<>();
        HashSet set = new HashSet();
        for(Map.Entry<Character,Integer> entry :a.entrySet()){
            set.add(entry.getKey());
            ax.add(entry.getValue());
        }


        char wc2[] = word2.toCharArray();
        Map<Character,Integer> a2 = new HashMap<>();
        for(int i=0;i<wc2.length;i++){
            if(a2.containsKey(wc2[i])){
                a2.put(wc2[i],a2.get(wc2[i])+1);
            }else{
                a2.put(wc2[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry :a2.entrySet()){
            int k = entry.getValue();
            set.remove(entry.getKey());
            if(!ax.contains(k)){
                return false;
            }
            ax.remove(ax.indexOf(k));
        }
        if(ax.size()>0||set.size()>0){
            return false;
        }
        return true;
    }


    @Test
    public void t(){
        closeStrings("abc","bca");
    }
}
