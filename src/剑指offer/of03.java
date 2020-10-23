package 剑指offer;

/**
 * @author Hujf
 * @title: of03
 * @date 2020/9/16 0016下午 2:12
 * @description: TODO
 */
public class of03 {
    public int findRepeatNumber(int[] nums) {
        nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int a[] = new int[100001];
        int ax=0;
        for(int i=0;i<nums.length;i++){
            if(a[nums[i]]==1){
                ax = nums[i];
                break;
            }
            a[nums[i]]=1;
        }
        return ax;
    }
}
