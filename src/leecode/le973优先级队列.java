package leecode;

import org.jcp.xml.dsig.internal.dom.DOMUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le973
 * @date 2020/11/9 0009上午 9:24
 * @description: TODO
 */
public class le973优先级队列 {
    //Array方法
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                //正 交换位置 负不交换
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }




    public int[][] kClosest2(int[][] points, int K) {
        TreeMap<Double,List<int[]>> m = new TreeMap<> ();
        for(int a[]:points){
            double len = a[0]*a[0]+a[1]*a[1];
            if(!m.containsKey(len)){
                m.put(len,new ArrayList<int[]>());
            }
            //获取到数组
            List asd =m.get(len);
            asd.add(a);
        }
        int ms = 0;
        Iterator it = m.entrySet().iterator();
        int adwwef[][]= new int[K][2];
        while (ms<K){
            Map.Entry<Double,List<int[]>> entry = (Map.Entry<Double, List<int[]>>) it.next();
            List<int[]> list = entry.getValue();
            for(int asd[] :list){
                adwwef[ms]=asd;
                ms++;
            }
        }
        return adwwef;
    }

    // 优先级队列
    public int[][] kClosest3(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int[][] ans = new int[K][2];
        return ans;
    }

    @Test
    public void t(){
        kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);
    }
}
