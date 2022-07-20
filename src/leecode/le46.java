package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/7/20 15:32
 * @Description TODO
 */
public class le46 {
    int[] nums;
    List b = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            List a = new ArrayList();
            Set<Integer> set = new HashSet<>();
            a.add(nums[i]);
            set.add(i);
            dfs(a, set);
        }
        return b;
    }

    private void dfs(List<Integer> a, Set<Integer> set) {
        if (a.size() == nums.length) {
            b.add(new ArrayList<>(a));
            return;
        }
        for (int i = 0;  i<nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            a.add(nums[i]);
            set.add(i);
            dfs(a, set);
            a.remove((Integer)nums[i]);
            set.remove(i);
        }
    }

    @Test
    public void t(){
        permute(new int[]{1,2,3});
    }
}
