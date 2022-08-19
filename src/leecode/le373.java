package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/8/18 15:42
 * @Description 4指针
 */
public class le373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int local1 = 0;
        int aim1 = 0;

        int local2 = 0;
        int aim2 = 0;
        List<List<Integer>> list = new ArrayList<>();

        int[][] nums = new int[nums1.length][nums2.length];

        while (list.size() < k) {
            List a = new ArrayList(2);
            int a1 = nums1[local1] + nums2[aim1];
            int a2 = nums2[local2] + nums1[aim2];

            if (a1 < a2) {
                if (nums[local1][aim1] == 0) {
                    nums[local1][aim1] = 1;
                    a.add(nums1[local1]);
                    a.add(nums2[aim1]);
                    list.add(a);
                }
                aim1++;
                if (aim1 == nums2.length) {
                    aim1 = 0;
                    local1++;
                    if (local1 == nums1.length) {
                        return list;
                    }
                }
            } else {
                if (nums[aim2][local2] == 0) {
                    nums[aim2][local2]=1;
                    a.add(nums1[aim2]);
                    a.add(nums2[local2]);
                    list.add(a);
                }
                aim2++;
                if (aim2 == nums1.length) {
                    aim2 = 0;
                    local2++;
                    if (local2 == nums2.length) {
                        return list;
                    }
                }
            }

        }
        return list;
    }


    @Test
    public void t() {
        kSmallestPairs(new int[]{-10,-4,0,0,6}, new int[]{3,5,6,7,8,100}, 10);
    }
}
