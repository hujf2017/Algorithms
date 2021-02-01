package leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le888
 * @date 2021/2/1 0001下午 12:29
 * @description: TODO
 */
public class le888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int numsa = Arrays.stream(A).sum();
        int numsb = Arrays.stream(B).sum();
        int del = (numsa-numsb)/2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + del;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
