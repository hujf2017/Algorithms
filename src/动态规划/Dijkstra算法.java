package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: Dijkstra算法
 * @date 2021/4/1212:00
 * @description:
 *
 * 有 n个城市，按从 0 到 n-1编号。给你一个边数组edges，
 * 其中 edges[i] = [fromi, toi, weighti]代表fromi和toi两个城市之间的双向加权边，距离阈值是一个整数distanceThreshold。
 *
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为distanceThreshold的城市。如果有多个这样的城市，则返回编号最大的城市。
 *
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Dijkstra算法 {
    final int max = 100000;
    //n个城市   对应城市间的距离
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //定义一个数组
        int [][] roads = new int[n][n];
        //初始化
//        for(int i=0;i<n;i++){
//            Arrays.fill(roads[i],max);
//        }
        //所有边
        for(int []road:roads){
            Arrays.fill(road,max);
        }
        //出书化对角线
        for(int i=0;i<n;i++){
            roads[i][i]=0;
        }
        //对edge中的边 初始化roads中
        for(int []edge:edges){
            roads[edge[0]][edge[1]] = roads[edge[1]][edge[0]] = edge[2];
        }

        //找到最小路径
        int ax =dijkstra(roads,n,distanceThreshold);
        return ax;
    }

    private int dijkstra(int[][] roads,int n,int distanceThreshold) {
        int MIN =n+1;
        int res =n+1;
        //从第i个开始
        for(int i=0;i<n;i++){
            //第i个到每一个的直接距离
            int []dist = new int[n];
            boolean[] set = new boolean[n];
            for(int j=0;j<n;j++){
                //得到距离
                dist[j] = roads[i][j];
            }
            //当前位置为0
            dist[i] = 0;
            set[i] = true;
            //开始循环 其实可排除本身 所以这里可以是n-1
            for(int j=0;j<n;j++){
                int min =max;
                int start = i;
                for(int k=0;k<n;k++){
                    if(!set[k]&&dist[k]<min){
                        min = dist[k];
                        start = k;
                    }
                }
                //表示当前最小的 需要设置访问过了
                set[start] = true;
                for(int k=0;k<n;k++){
                    if(!set[k]&&dist[k]>dist[start]+roads[start][k]){
                        dist[k] = dist[start]+roads[start][k];
                    }
                }
            }

            //这里就可以得到每个城市 到另外一个城市的最短距离数组了
            int tmp =0;
            for(int j :dist ){
                if(j<=distanceThreshold){
                    tmp++;
                }
            }
            if(tmp<=MIN){
                MIN =tmp ;
                res = i;
            }
        }
        return res;
    }

    int a[][] = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
    @Test
    public void t(){
        findTheCity (4,a,4);
    }
}