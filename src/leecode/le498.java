package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author hujf
 * @Date 2022/6/14 9:22
 * @Description TODO
 */
public class le498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int y =mat[0].length;
        int x =  mat.length;
        int count = 0;
        int x1 = 0;
        int y1 = 0;
        int [][]flag =  new int[x][y];

        int[] k = new int[x * y];
        Deque<int[]> queue = new LinkedList();
        int [] nums =new int[2];
        nums[0] = x1;
        nums[1] = y1;
        k[count] = mat[x1][y1];
        flag[x1][y1]=-1;
        queue.add(nums);
        queue.add(null);
        boolean turn = false;
        while(queue.size()>0){
            if(count+1==x*y){
                break;
            }
            int[] ints ;
            if(turn) {
                ints  = queue.pollLast();
            }else {
                ints  = queue.pollFirst();
            }

            if(ints==null){
                if(turn){
                    queue.addLast(null);
                }else{
                   queue.addFirst(null);
                }
                turn = !turn;
                continue;
            }
             x1 = ints[0];
             y1 = ints[1];

             if(turn){
                 if(x1+1<x&&flag[x1+1][y1]==0){
                     count++;
                     queue.addFirst(new int[]{x1+1,y1});
                     flag[x1+1][y1] = -1;
                     k[count] = mat[x1+1][y1];
                 }

                 if(y1+1<y&&flag[x1][y1+1]==0){
                     count++;
                     queue.addFirst(new int[]{x1,y1+1});
                     flag[x1][y1+1] = -1;
                     k[count] = mat[x1][y1+1];
                 }
             }else{
                 if(y1+1<y&&flag[x1][y1+1]==0){
                     count++;
                     queue.add(new int[]{x1,y1+1});
                     flag[x1][y1+1] = -1;
                     k[count] = mat[x1][y1+1];
                 }

                 if(x1+1<x&&flag[x1+1][y1]==0){
                     count++;
                     queue.add(new int[]{x1+1,y1});
                     flag[x1+1][y1] = -1;
                     k[count] = mat[x1+1][y1];
                 }
             }
        }

        return k;
    }


    @Test
    public void t(){
        findDiagonalOrder(new int[][] {{1,2},{4,5},{7,8}});
    }
}
