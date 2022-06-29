package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/28 11:21
 * @Description 0<1>2<3>4<5</3>
 */
public class le324 {
    public void wiggleSort(int[] nums) {
        int[] num2 = new int[nums.length];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        int index = -1;
        while (left < right) {
            int k = nums[left++];
            int m = nums[right--];
            num2[count++] = k;
            num2[count++] = m;
            if (k == m) {
                index = count - 2;
            }
        }

        if (left == right) {
            num2[count] = nums[left];
        }
        nums = num2;
        // 从index开始 调整
        for (int i = index - 1; i < nums.length; i++) {
            if (i < 0) {
                return;
            } else {

            }
        }
    }


    public void wiggleSort2(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int k = (nums.length + 1) / 2;
        int count = 0;
        int left = k-1;
        int right = nums.length-1;
        while (count < clone.length) {
            if(count < clone.length) nums[count++] = clone[left--];
            if(count < clone.length)  nums[count++] = clone[right--];
        }
        return;
    }

    @Test
    public void t(){
        wiggleSort2(new int[]{1,5,1,1,4});

    }
}
