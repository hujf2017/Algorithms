package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author hujf
 * @Date 2022/6/14 10:14
 * @Description TODO
 */
public class le2306 {


    Set<String> set2 = new HashSet<>();
    public long distinctNames(String[] ideas) {
        for(String s:ideas){
            set.add(s);
        }
        for(int i=0;i<ideas.length;i++){
            for(int j=i+1;j<ideas.length;j++){
                String idea = ideas[i];
                String ideb = ideas[j];
                if(!swap(idea,ideb)){
                    set2.add(idea+" "+ideb);
                }
            }
        }

        return set2.size()*2;
    }

    private boolean swap(String idea, String idea1) {
        String ideasub = idea.substring(0,1);
        String idebsub = idea1.substring(0,1);
        String s = idea.replaceFirst(ideasub, idebsub);
        String s1 = idea1.replaceFirst(idebsub, ideasub);
        return set.contains(s)||set.contains(s1);
    }

    @Test
    public void t(){
        distinctNames2(new String[]{"coffee","donuts","time","toffee"});
    }
    Set<String> set = new HashSet<>();
    //这个交换
    public long distinctNames2(String[] ideas) {

       set =  Arrays.stream(ideas).collect(Collectors.toSet());

        int[][] num = new int[26][26];
        long ret = 0;
        for(String s : ideas){
            int i = s.charAt(0) - 'a';
            for(int j = 0 ; j < 26 ; j++){
                String ns = (char)('a'+j)+(s.length() > 1 ? s.substring(1) : "");
                if(!set.contains(ns)){
                    num[i][j]++;
                    ret += num[j][i];
                }
            }
        }
        return ret*2;
    }
}
