package 比赛;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author hujf
 * @Date 2022/3/15 17:46
 * @Description TODO
 */
public class le2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            parents.get(edges[i][1]).add(edges[i][0]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> parent = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int index = queue.poll();
                List<Integer> integers = parents.get(index);
                for (Integer integer : integers) {
                    if(!parent.contains(integer)){
                        queue.offer(integer);
                    }
                    parent.add(integer);
                }
            }
            result.add(parent.parallelStream().sorted().collect(Collectors.toList()));
        }


        return result;
    }


    @Test
    public void te() {
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}; // [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
        getAncestors(8, edges);
    }

}
