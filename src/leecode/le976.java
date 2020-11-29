package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le976
 * @date 2020/11/29 0029下午 1:28
 * @description: TODO
 */
public class le976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        //最长边
        for(int i=A.length-1;i>=2;i--){
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if(a<b+c){
                return a+b+c;
            }
        }
        return 0;
    }
}
