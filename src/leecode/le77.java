package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/28 17:45
 * @Description dfs
 */
public class le77 {
    List<List<Integer>> a = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        int[] num = new int[n + 1];
        dfs(k, n, new ArrayList<>(), num);
        return a;
    }

    private void dfs(int k, int n, List list, int[] num) {
        if (list.size() == k) {
            a.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (num[i] == 0) {
                num[i] = 1;
                list.add(i);
                dfs(k, n, list, num);
                list.remove(list.size() - 1);
                num[i] = 0;
            }
        }
    }


    @Test
    public void te(){
        combine(4,2);
    }
}
