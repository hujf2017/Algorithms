package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/8/19 10:44
 * @Description TODO
 */
public class le1590 {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        long []sums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i]= sum;
        }

        if (sum < p) {
            return -1;
        } else if (sum%p == 0) {
            return 0;
        } else {
            //在数组中找到最短和 为k的 子数组
            Map<Long, Integer> help = new HashMap<>();
            help.put(sum%p,-1);
            int min =nums.length;
            for(int i=0;i<nums.length;i++){

                help.put((sums[i]+sum)%p,i);
                long mod =  sums[i] % p;
                if(help.containsKey(mod)){
                    min = Math.min(min,i-help.get(mod));
                }

            }
            return min==nums.length ?-1:min;
        }
    }

    @Test
    public void t(){
        System.out.println(minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
    }
}
