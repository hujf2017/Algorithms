package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/6/27 15:45
 * @Description TODO
 */
public class le6103 {
    static int[] num;
    public int minimumScore(int[] nums, int[][] edges) {
        //设置一个并查集 用于连接所有的线

        int mix =Integer.MAX_VALUE;
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                num = new int[nums.length+1];
                //去除edges[i]  edges[j]  两根线
                num[edges[i][0]+1]=edges[i][0]+1;
                num[edges[i][1]+1]=edges[i][1]+1;
                num[edges[j][0]+1]=edges[j][0]+1;
                num[edges[j][1]+1]=edges[j][1]+1;



                for (int k = 0; k < edges.length; k++) {
                    if (k != i && k != j) {
                        binary(edges[k]);
                    }
                }
               Map<Integer,Set> map = new HashMap<>();
                //计算异或值
                for (int x=1;x<num.length;x++){
                    int k =find(num[x]);
                    Set orDefault = map.getOrDefault(k, new HashSet());
                    orDefault.add(x);
                    map.put(k,orDefault);
                }
                if(map.size()!=3){
                    throw new RuntimeException("有问题");
                }
                List<Integer> a = new ArrayList(3);
                Iterator<Map.Entry<Integer, Set>> iterator = map.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<Integer, Set> next = iterator.next();
                    Set <Integer>value = next.getValue();
                    Iterator<Integer> iterator1 = value.stream().iterator();
                    Integer next1 = nums[iterator1.next()-1];


                    while(iterator1.hasNext()){
                        next1=next1^nums[iterator1.next()-1];
                    }
                    a.add(next1);
                }

                Collections.sort(a);
                mix = Math.min(a.get(2)-a.get(0),mix);
            }
        }
        return mix;
    }

    private void binary(int[] edge) {
        int k = edge[0]+1;
        if (num[k] == 0) {
            num[k] = k;
        }
        if (num[ edge[1]+1] == 0) {
            num[edge[1]+1] = edge[1]+1;
        }
        int index =find(k);
        int index2 =find(edge[1]+1);
        num[index2] = index;
    }

    private int find(int k) {
        while(num[k]!=k){
            k = num[k];
        }
        return k;
    }



    @Test
    public void t(){
        minimumScore(new int[]{5,5,2,4,4,2},new int[][]{{0,1},{1,2},{5,2},{4,3},{1,3}});
       // minimumScore(new int[]{1,5,5,4,11},new int[][]{{0,1},{1,2},{1,3},{3,4}});
    }


}
