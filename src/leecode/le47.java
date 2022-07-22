package leecode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author hujf
 * @Date 2022/7/21 15:58
 * @Description TODO
 */
public class le47 {


    int[] nums;
    List b = new ArrayList();
    Set<String> set = new HashSet<>();
    int [] numxxx;
    public List<List<Integer>> permuteUnique(int[] nums) {
        numxxx = new int[nums.length];
        this.nums = nums;
        Arrays.sort(this.nums);
        dfs(new ArrayList<Integer>(),0);

        return b;
    }

    private void dfs( List <Integer>list,int len) {
        if (len >= nums.length) {
            b.add(new ArrayList<>(list));
           return;
        }
        for (int i = 0;  i<nums.length; i++) {
            if (numxxx[i]==1||(i>0&&nums[i]==nums[i-1]&&numxxx[i-1]==0)) {
                continue;
            }
            list.add(nums[i]);

            numxxx[i]=1;
            dfs( list,len+1);
            list.remove(list.size()-1);
            numxxx[i]=0;
        }
    }

    @Test
    public void t(){
        permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1});
    }

}
