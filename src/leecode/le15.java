package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/6/16 14:23
 * @Description 三数之和
 */
public class le15 {
    Map<Integer, HashSet> map = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        int[] num = new int[200001];

        for (int i : nums) {
            num[i + 100000] = num[i + 100000]+1;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int m = nums[i] + nums[j];
                if(m>100000||m<-100000){
                    continue;
                }
                num[nums[i] + 100000]--;
                num[nums[j] + 100000]--;
                if (num[-m + 100000] > 0) {
                    if (no(nums[i], nums[j], -m)) {
                        ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(nums[i]);
                        objects.add(nums[j]);
                        objects.add(-m);
                        HashSet orDefault = map.getOrDefault(nums[i], new HashSet());
                        orDefault.add(nums[j]);
                        map.put(nums[i], orDefault);
                        list.add(objects);
                    }
                }
                num[nums[i] + 100000]++;
                num[nums[j] + 100000]++;
            }
        }
        return list;
    }

    private boolean no(int num, int num1, int num2) {
        HashSet x;
        if ((x = map.get(num)) != null) {
            if (x.contains(num1) || x.contains(num2)) {
                return false;
            }
        }
        if ((x = map.get(num1)) != null) {
            if (x.contains(num) || x.contains(num2)) {
                return false;
            }
        }
        if ((x = map.get(num2)) != null) {
            if (x.contains(num1) || x.contains(num)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
