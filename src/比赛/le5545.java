package 比赛;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Hujf
 * @title: le5545
 * @date 2020/10/18 0018上午 11:13
 * @description: TODO
 */
public class le5545 {
    int s[] ;
    int a[] ;
    int max = 0;
    int len;
    Map<Integer,Integer> axs= new TreeMap<>();
    List<Integer> ax = new ArrayList<>();
    public int bestTeamScore(int[] scores, int[] ages) {
        s= scores;
        a=ages;
        len= scores.length;
        for(int i=0;i<len;i++){
            //得到排序
            axs.put(ages[i],scores[i]);
        }

        for(Map.Entry<Integer,Integer> entry  :axs.entrySet()){
            ax.add(entry.getKey());
        }

        for(int i=0;i<len;i++){
            dfs(0,0,ax.get(i),axs.get(ax.get(i)));
        }
        System.out.println(max);
      return max;
    }


    public void dfs(int lcial,int sum,int le1,int len2){
        if(sum>max){
            max =sum;
        }
        for(int i=lcial;i<len;i++){
            if(ax.get(i)>=le1&&axs.get(ax.get(i))>=len2){
                dfs(i+1,sum+a[i],ax.get(i),axs.get(ax.get(i)));
            }
        }
    }

    @Test
    public void test(){
        int a[] ={9,2,8,8,2};
        int b[] ={4,1,3,3,5};
        bestTeamScore(a,b);
    }
}
