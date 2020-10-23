package leecode;

/**
 * @author Hujf
 * @title: le1464
 * @date 2020/9/14 0014下午 1:00
 * @description: TODO
 */
public class le1464 {

    public int maxProduct(int[] nums) {
        int max =0;
        int max2 = 0;
        for(int i=0;i<nums.length;i++){
         if(nums[i]>=max){
             int mid = max;
             max= nums[i];
             max2 = mid ;
         }else if(nums[i]>max2){
             max2 = nums[i];
         }else{
         }
        }
        return (max-1)*(max2-1);
    }
}
