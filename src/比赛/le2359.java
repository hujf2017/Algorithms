package 比赛;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/1 17:03
 * @Description TODO
 */
public class le2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int i = 0;
        int[] ed1 = new int[edges.length];
        Arrays.fill(ed1,Integer.MAX_VALUE);
        while (edges[node1] != -1) {
            if(i==edges.length){
                //成环  找到当前节点 到
                int a = ed1[node2];
                int k = i-a;

                if(k>a){
                   return  node1;
                } else if(k<a){
                    return node2;
                }else {
                    return Math.min(node1,node2);
                }
            }
            ed1[node1] = i++;
            node1 = edges[node1];

        }
        ed1[node1] = i;
        int[] ed2 = new int[edges.length];
        Arrays.fill(ed2,Integer.MAX_VALUE);
        i=0;
        while (edges[node2] != -1) {
            ed2[node2] = i++;
            node2 = edges[node2];
        }
        ed2[node2] = i;
        int min =Integer.MAX_VALUE;
        int index =0;
        for(int x=0;x<ed2.length;x++){
            int max = Math.max(ed1[x], ed2[x]);
           if(min>max){
               index = x;
               min = max;
           }
        }
        return min==Integer.MAX_VALUE?-1:index;
    }

    //[9,8,7,0,5,6,1,3,2,2]
    //1
    //6



    @Test
    public void t(){
        closestMeetingNode(new int[]{9,8,7,0,5,6,1,3,2,2},1,6);
    }
}
