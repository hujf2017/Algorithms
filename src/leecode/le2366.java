package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/9 14:47
 * @Description TODO
 */
public class le2366 {
    public long minimumReplacement(int[] nums) {
        int[] numIn = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = numIn.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            numIn[i] = min;
        }
        long count = 0;
        for (int i = numIn.length - 2; i >= 0; i--) {
            int num = nums[i];
            int minnow = numIn[i+1];
            count += calc(num, minnow, numIn, i);
        }
        return count;
    }

    private int calc(int num, int minnow, int[] numIn, int index) {
        int count = num / minnow;

        int avg = num/(count+1);
        if (num % minnow == 0) {
            numIn[index] = Math.min(minnow,numIn[index]);
            return count-1;
        } else {
            numIn[index] =  Math.min(avg,numIn[index]);
            return count ;
        }
    }

    @Test
    public void t() {
      //  int[] ints= {12,9,7,6,17,19,21};

         int[] ints = {19,7,2,24,11,16,1,11,23};
      //  int[] ints = {3,9,2};
        minimumReplacement(ints);
    }
}
