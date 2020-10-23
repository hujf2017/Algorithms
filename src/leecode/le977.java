package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le977
 * @date 2020/10/16 0016上午 11:36
 * @description: TODO
 */
public class le977 {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
