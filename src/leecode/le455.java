package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le455
 * @date 2020/10/30 0030上午 9:50
 * @description: TODO
 */
public class le455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sj = 0;
        int count = 0;

        for(int i=0;i<g.length;i++){
           while(sj<s.length){
               if(g[i]<=s[sj]){
                   count ++;
                   sj++;
                   break;
               }
               sj++;
           }
        }
        return count;
    }

    @Test
    public void t(){
        findContentChildren(new int[]{1,2,3},new int[]{1,1});
    }
}
