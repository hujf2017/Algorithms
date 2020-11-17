package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hujf
 * @title: le1030
 * @date 2020/11/17 0017下午 1:42
 * @description: TODO
 */
public class le1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int array[][] = new int[R*C][2];
        int count =0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                array[count] = new int[]{i,j};
                count++;
            }
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0))-(Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0));
            }
        });
        return array;
    }


    @Test
    public void t(){
        allCellsDistOrder(2,3,1,2);
    }
}
