package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/5 11:16
 * @Description TODO
 */
public class le78 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<Integer>());
        lists.add(new ArrayList<>());
        return lists;
    }

    private void dfs(int[] nums,int begin,List <Integer> list) {
        while(begin==nums.length){
            return;
        }
        for(int i=begin;i<nums.length;i++){
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            dfs(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void te(){
        subsets(new int[]{1,2,3});
    }
}
