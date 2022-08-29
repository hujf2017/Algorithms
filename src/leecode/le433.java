package leecode;

import org.junit.Test;

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

    String end ;

    public int minMutation(String start, String end, String[] bank) {
        this.end = end;
        int min =Integer.MAX_VALUE;
        for(int i=0;i< bank.length;i++){
            if(start.equals(end)){
                return 0;
            }
            boolean [] used = new boolean[bank.length];
            used[i]=true;
            if(panduan(start,bank[i])==1){
                min = Math.min(min, dfs(i,used,bank,1));
            }
            used[i]=false;
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    private int dfs(int  next, boolean [] used,String[] bank,int count ) {
        if(bank[next].equals(end)){
            return count;
        }

        used[next] = true;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<bank.length;i++){
            if(!used[i]&&panduan(bank[next],bank[i])==1){
                 min=  Math.min(min,dfs(i,used,bank,count+1));
            }
        }
        used[next] = false;
        return min;
    }

    private int panduan(String start, String end) {
        char[] chars = start.toCharArray();
        char[] chars1 = end.toCharArray();
        int count =0;
        int count2 =0;
        while(count<chars.length){
            if(chars[count]!=chars1[count]){
                count2++;
            }
            count++;
        }
        return count2;
    }

    @Test
    public void t(){
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAAACCCA","AAACCCCC","AACCCCCC"}));
    }

}
