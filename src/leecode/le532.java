package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/6/16 10:47
 * @Description TODO
 */
public class le532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int x = map.getOrDefault(nums[i], 0);
            map.put(nums[i], x + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if (k != 0) {
                if (map.containsKey(key + k)) {
                    count++;
                }
                if (map.containsKey(key - k)) {
                    count++;
                }
            } else {
                if(value>1){
                    count++;
                }
            }
        }

        return k == 0 ? count : count / 2;
    }

    @Test
    public void t() {
        findPairs(new int[]{3, 1, 4, 1, 5}, 0);
    }
}
