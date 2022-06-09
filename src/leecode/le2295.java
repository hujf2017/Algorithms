package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/6/9 9:51
 * @Description 先把所有的数字 初始和结束都改好了  类似并查集
 */
public class le2295 {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, List<Integer>> mapList = new HashMap<>();
    public int[] arrayChange(int[] nums, int[][] operations) {
        for (int[] op : operations) {
            //第一步 判断之前是否有key
            if(mapList.containsKey(op[0])){
                List<Integer> list = mapList.get(op[0]);
                mapList.remove(op[0]);
                mapList.put(op[1],list);
            }else{
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(op[0]);
                mapList.put(op[1],objects);
            }
        }
        //然后对 maplist 转map
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = mapList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            Integer key = next.getKey();
            List<Integer> value = next.getValue();
            for(int num :value){
                map.put(num,key);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            //查询得到这个数应该变成的东西
            int k = map.getOrDefault(nums[i],nums[i]);
            nums[i] = k;
        }

        return nums;
    }


    @Test
    public void t() {
        arrayChange(new int[]{1, 2, 3, 4}, new int[][]{{4, 5}, {3, 4}, {2, 3}, {1, 2}, {5, 1}, {4, 5}});
    }
}
