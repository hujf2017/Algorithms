package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/18 9:21
 * @Description TODO
 */
public class le1224 {

    //暴力

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i, orDefault + 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (panduan(map)) {
                return i + 1;
            }
            Integer integer = map.get(nums[i]);
            map.put(nums[i], integer - 1);
        }
        return 1;
    }

    private boolean panduan(Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int a = -1;
        int aunm = 0;
        int b = -1;
        int bunm = 0;
        int x = -1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 0) {
                continue;
            }
            if (a == -1 || a == next.getValue()) {
                a = next.getValue();
                aunm++;
            } else if (b == -1 || b == next.getValue()) {
                b = next.getValue();
                bunm++;
            } else {
                if (next.getValue() == a) {
                    aunm++;
                } else if (next.getValue() == b) {
                    bunm++;
                } else {
                    return false;
                }
            }
            if (aunm > 1 && bunm > 1) {
                return false;
            }
        }
        //至少有一个为1
        if (bunm == 0) {
            if (aunm==1||a == 1) {
                return true;
            }
            return false;
        } else {
            if (aunm == 1) {
                if (a - b == 1 || a == 1) {
                    return true;
                }
                return false;
            } else {
                if (b - a == 1 || b == 1) {
                    return true;
                }
                return false;
            }
        }
    }


    @Test
    public void t() {
        //   [10,2,8,9,3,8,1,5,2,3,7,6]

        //{10,2,8,9,3,8,1,5,2,3,7,6}
        System.out.println(maxEqualFreq(new int[]{1,1}));
    }

}
