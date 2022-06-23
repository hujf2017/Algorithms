package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/6/23 9:52
 * @Description 桶排序 前K个
 */
public class le347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        Map<Integer, Integer> maps = new HashMap(nums.length);
        //得到了所有的次数  映射为 次数 -数字数组
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = maps.getOrDefault(nums[i], 0);
            orDefault++;
            maps.put(nums[i], orDefault);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = maps.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            List<Integer> orDefault = map.getOrDefault(value, new ArrayList<>());
            orDefault.add(key);
            map.put(value, orDefault);
        }


//        int[] num = new int[10001];
//        for (int i = 0; i < nums.length; i++) {
//            num[nums[i]]++;
//        }
//
//        //得到了所有的次数  映射为 次数 -数字数组
//        for (int i = 0; i < 10001; i++) {
//            if(num[i]!=0) {
//                List<Integer> orDefault = map.getOrDefault(num[i], new ArrayList<>());
//                orDefault.add(i);
//                map.put(num[i], orDefault);
//            }
//        }
        int nu[] = new int[k];
        int count = 0;
        //从上往下搜索   最大次数10000
        for (int i = 10000; i > 0; i--) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (int ls : list) {
                    nu[count++] = ls;
                }
            }
            if (count == k) {
                break;
            }
        }

        return nu;
    }

    @Test
    public void test() {
        topKFrequent(new int[]{-1, -1}, 1);
    }
}
