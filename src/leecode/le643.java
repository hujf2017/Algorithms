package leecode;

/**
 * @author Hujf
 * @title: le643
 * @date 2021/2/4 0004上午 8:56
 * @description: TODO
 */
public class le643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max =0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        max = Math.max(sum,max);
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i]-nums[i-k];
            max = Math.max(sum,max);
        }
        return (double)max/k;
    }
}
