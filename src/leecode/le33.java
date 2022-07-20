package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/7/20 14:26
 * @Description TODO
 */
public class le33 {
    int[] num;
    int target;

    public int search(int[] nums, int target) {
        this.num = nums;
        this.target = target;
        return dfs(0, nums.length-1);
    }

    private int dfs(int start, int end) {
        int nums = -1;
        int k =(start + end) / 2;
        if (num[k] == target) {
            return (start + end) / 2;
        }
        if (start < end) {
            nums = dfs(start,k-1);
            if(nums!=-1){
                return nums;
            }
            nums = dfs(k+1,end);
        }
        return nums;
    }


    @Test
    public void t() {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
