package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le1046
 * @date 2020/12/30 0030上午 9:54
 * @description: TODO
 */
public class le1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length - 1;
        for (int i = len; i > 0; i--) {
            stones[len] = stones[len] - stones[len - 1];
            stones[len - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[len];
    }
}
