package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/4 9:44
 * @Description TODO
 */
public class le40 {

    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target, new ArrayList<>(), 0, candidates);
        return list;
    }
    int last;
    private void dfs(int target, List<Integer> path, int begin, int[] candidates) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(path));
        } else {
            for (int i = begin; i < candidates.length; i++) {
                if(last!=candidates[i]) {
                    path.add(candidates[i]);
                    dfs(target - candidates[i], path, i + 1, candidates);
                    path.remove(path.size() - 1);
                    last = candidates[i];
                }
            }
        }
    }

    @Test
    public void t() {
        combinationSum2(new int[]{10,1,2,7,6,1,5
        }, 8);
    }
}
