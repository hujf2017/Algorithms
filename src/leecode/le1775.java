package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/12/7 17:35
 * @Description TODO
 */
public class le1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }

        int sum1 = 0;
        int sum2 = 0;
        int[] num1 = new int[7];
        for (int i : nums1) {
            num1[i]++;
            sum1 += i;
        }
        int[] num2 = new int[7];
        for (int i : nums2) {
            num2[i]++;
            sum2 += i;
        }

        if (sum2 > sum1) {
            int left = sum2 - sum1;
            return calc(num2, num1, left);
        } else {
            int left = sum1 - sum2;
            return calc(num1, num2, left);
        }
    }

    private int calc(int[] num1, int[] num2, int left) {
        int need = 0;
        for (int i = 6; i > 0; i--) {
            left = left - num1[i] * (i - 1);
            if (left <= 0) {
                need += (num1[i] * (i - 1)+left+i-2)/(i-1);
                return need;
            } else {
                need += num1[i];
            }
        }
        //如果剪完了 还不行
        return need + (left+4) / 5;
    }


    @Test
    public void t() {
        System.out.println(minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2}));
    }
}
