package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/11/9 17:40
 * @Description TODO
 */
public class le2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> ser = new HashSet();
        Map<Integer, Set> map = new HashMap<>();
        for (int i : restricted) {
            ser.add(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!ser.contains(x) && !ser.contains(y)) {
                Set orDefault = map.getOrDefault(x, new HashSet());
                orDefault.add(y);
                map.put(x, orDefault);

                Set orDefault2 = map.getOrDefault(y, new HashSet());
                orDefault2.add(x);
                map.put(y, orDefault2);
            }
        }

        Deque<Integer> deque = new ArrayDeque();
        deque.add(0);
        ser.add(0);
        int count = 1;
        while (deque.size() > 0) {
            Integer poll = deque.poll();
            Set<Integer> set = map.get(poll);
            if(set.size()>0) {
                for (int numx : set) {
                    if (!ser.contains(numx)) {
                        deque.add(numx);
                        count++;
                        ser.add(numx);
                    }
                }
            }
        }
        return count;
    }

    //7
    //[[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]]
    //[4,5]
    @Test
    public void t() {
        reachableNodes(2, new int[][]{{0, 1}}, new int[]{1});
    }
}

