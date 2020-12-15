package leecode;

/**
 * @author Hujf
 * @title: le376动态规划
 * @date 2020/12/12 0012下午 7:41
 * @description: TODO
 */
public class le376动态规划 {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int[] up = new int[nums.length];
        int []down = new int[nums.length];
        up[0] = down[0] = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i] = Math.max(down[i-1]+1,up[i-1]);
                down[i] = down[i-1];
            }else if(nums[i]<nums[i-1]){
                down[i] = Math.max(down[i-1],up[i-1]+1);
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }

    public static void main(String[] args) {

    }
}
