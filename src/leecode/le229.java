package leecode;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * @Author hujf
 * @Date 2022/11/9 16:52
 * @Description TODO
 */
public class le229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length / 3;
        List<Integer> s = new ArrayList(n);
        //出现次数大于n
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i : nums) {
            Integer orDefault = map.getOrDefault(i, 0);
            orDefault++;
            map.put(i, orDefault);
            if (orDefault == n + 1) {
                s.add(i);
            }
        }
        return s;
    }

    @Test
    public void t() {
        majorityElement2(new int[]{0,0,0});
    }

    public List<Integer> majorityElement2(int[] nums) {
//        int element1 = 0;
//        int element2 = 0;
//        int vote1 = 0;
//        int vote2 = 0;
//
//        for (int num : nums) {
//            if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
//                vote1++;
//            } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
//                vote2++;
//            } else if (vote1 == 0) { // 选择第一个元素
//                element1 = num;
//                vote1++;
//            } else if (vote2 == 0) { // 选择第二个元素
//                element2 = num;
//                vote2++;
//            } else { //如果三个元素均不相同，则相互抵消1次
//                vote1--;
//                vote2--;
//            }
//        }
//
//        int cnt1 = 0;
//        int cnt2 = 0;
//        for (int num : nums) {
//            if (vote1 > 0 && num == element1) {
//                cnt1++;
//            }
//            if (vote2 > 0 && num == element2) {
//                cnt2++;
//            }
//        }
//        // 检测元素出现的次数是否满足要求
//        List<Integer> ans = new ArrayList<>();
//        if (vote1 > 0 && cnt1 > nums.length / 3) {
//            ans.add(element1);
//        }
//        if (vote2 > 0 && cnt2 > nums.length / 3) {
//            ans.add(element2);
//        }
//
//        return ans;
        List<Integer> a = new ArrayList();
        if (nums.length == 1) {
            a.add(nums[0]);
            return a;
        }

        int n = nums.length / 3;
        int[][] dp = new int[2][2];

        //出现次数大于n
        for (int i = 0; i < nums.length; i++) {
            if (dp[1][0] > 0 && nums[i] == dp[0][0]) {
                dp[1][0]++;
            } else if (dp[1][1] > 0 && nums[i] == dp[0][1]) {
                dp[1][1]++;
            } else if (dp[1][0] == 0) {
                dp[0][0] = nums[i];
                dp[1][0]++;
            } else if (dp[1][1] == 0) {
                dp[0][1] = nums[i];
                dp[1][1]++;
            } else {
                dp[1][0]--;
                dp[1][1]--;
            }
        }
        if(dp[1][0]<=0){
            dp[1][0] = -n;
        }else {
            dp[1][0] = 0;
        }
        if(dp[1][1]<=0){
            dp[1][1] = -n;
        }else {
            dp[1][1] = 0;
        }

        for(int i:nums){
            if(i == dp[0][0]){
                dp[1][0]++;
            }
            if(i == dp[0][1]){
                dp[1][1]++;
            }
        }

        if(dp[1][0]>n){
            a.add(dp[0][0]);
        }
        if(dp[1][1]>n){
            if(dp[0][1]!=dp[0][0]) {
                a.add(dp[0][1]);
            }
        }
        return a;
    }
}
