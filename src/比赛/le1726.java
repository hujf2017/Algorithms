package 比赛;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le1726
 * @date 2021/1/21 0021上午 9:27
 * @description: TODO
 */
public class le1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> a = new HashMap();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int nu = nums[i]*nums[j];
                int n =a.getOrDefault(nu,0);
                a.put(nu,++n);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = a.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e = it.next();
            num+=calc((Integer) e.getValue());
        }

        return num*8;


//        Arrays.sort(nums);
//        Set<Integer> s = new HashSet();
//        for (int a : nums) {
//            s.add(a);
//        }
//        int num = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                Set<Integer> ss = new HashSet<>(s);
//                int k = nums[i] * nums[j];
//                for (int z = i + 1; z < j; z++) {
//                    if (k % nums[z] == 0 && ss.contains(k / nums[z])&&nums[z]!=k/nums[z]) {
//                        ss.remove(nums[z]);
//                        ss.remove(k / nums[z]);
//                        num++;
//                    }
//                }
//            }
//        }
//        return num*8;
    }

    private int calc(int value) {
        if(value<2){
            return 0;
        }else {
            return value*(value-1)/2;
        }
    }

    @Test
    public void t() {
        tupleSameProduct(new int[]{2,3,4,6,8,12});
    }
}
