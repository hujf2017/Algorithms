package 比赛;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le5536网络秩
 * @date 2020/10/11 0011上午 10:40
 * @description: TODO
 */
public class le5536网络秩 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int cityNum[] = new int[n];
        Set<String> set = new HashSet<String>();
        for(int i=0;i<roads.length;i++){
            int city1 = roads[i][0];
            int city2 = roads[i][1];
            cityNum[city1]+=1;
            cityNum[city2]+=1;
            if(city1>city2) {
                set.add(city2 + "" + city1);
            }else{
                set.add(city1 + "" + city2);
            }
        }
        int max =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int s = cityNum[j]+cityNum[i];
                if(set.contains(i+""+j)){
                    s--;
                }
                if(s>max){
                    max = s;
                }
            }
        }
        return max;
    }
}
