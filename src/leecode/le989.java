package leecode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: le989
 * @date 2021/1/22 0022上午 9:44
 * @description: TODO
 */
public class le989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List a = new LinkedList();
        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int c = A[i] + K % 10+count;
            K = K / 10;
            count = c / 10;
            a.add(0,c%10);
        }

        while(K!=0){
            int c = K+count;
            a.add(0,c%10);
            K=c/10;
            count=0;
        }
        if(count!=0){
            a.add(0,count);
        }
        return a;
    }
}
