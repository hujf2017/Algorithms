package leecode;

/**
 * @author Hujf
 * @title: le219
 * @date 2020/10/16 0016上午 11:47
 * @description: TODO
 */
public class le219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=k;++j){
                if(i+j+1==nums.length-1){
                    continue;
                }
                if(nums[i]==nums[i+j+1]){
                    return true;
                }
            }
        }
        return false;
    }
}
