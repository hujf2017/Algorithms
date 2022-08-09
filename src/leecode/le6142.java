package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/8 9:18
 * @Description TODO
 */
public class le6142 {
    public long countBadPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= i;
        }
        Map<Integer, Long> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i, 0L)+1);
        }
        long x = nums.length*(nums.length-1)/2;
        Iterator<Map.Entry<Integer, Long>> iterator = map.entrySet().iterator();
        long ok = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer, Long> next = iterator.next();
            long num =next.getValue();
            if(num>=2){
                x-=num*(num-1)/2;
            }
        }

        return x-ok;

    }

    @Test
    public void t(){
        int[] ints = {4, 1, 3, 3};
        countBadPairs(ints);
    }
}
