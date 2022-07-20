package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author hujf
 * @Date 2022/7/20 14:13
 * @Description TODO
 */
public class le1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Deque<Integer> deque = new LinkedBlockingDeque();

        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                deque.add(grid[i][j]);
            }
        }

        for(int i=0;i<k;i++){
            Integer integer = deque.pollLast();
            deque.addFirst(integer);
        }
        List a = new ArrayList();
        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>();

            for(int j=0;j<n;j++){
                list.add(deque.poll());
            }
            a.add(list);
        }
        return  a;
    }
    @Test
    public void t(){
        shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1);
    }
}
