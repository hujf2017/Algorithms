package leecode;

/**
 * @author Hujf
 * @title: le416
 * @date 2020/10/11 0011上午 10:27
 * @description: TODO
 */
public class le416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2==1){
            return false;
        }
        aim =sum/2;
        dfs(nums,0,0);
        return isOk;
    }
    int aim;
    boolean isOk=false;
    private void dfs(int[] nums,int num,int now) {
        if(now ==aim||isOk==true){
            isOk =true;
            return ;
        }
        for(int i=num;i<nums.length;i++ ){
            dfs(nums,i+1,now+nums[i]);
        }
    }
}
