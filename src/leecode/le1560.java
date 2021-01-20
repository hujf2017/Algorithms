package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le1560
 * @date 2021/1/19 0019下午 12:02
 * @description: xunhuan
 */
public class le1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int []a = new int[n+1];
        int start = rounds[0];
        a[start] +=1;
        start = start%n;
        for(int i=1;i<rounds.length;i++){
            while (start!=rounds[i]){
                start++;
                if(start>n){
                    start =start%n;
                }
                a[start]+=1;
            }
        }
        int max =0;
        List sad = new ArrayList();
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                sad.clear();
                sad.add(i);
                max = a[i];
            }else if(a[i]==max){
                sad.add(i);
            }else{

            }
        }
        return sad;
    }


    @Test
    public void t(){
        mostVisited(2,new int[]{2,1,2,1,2,1,2,1,2});
    }
}
