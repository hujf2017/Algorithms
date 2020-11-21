package leecode;

/**
 * @author Hujf
 * @title: le645
 * @date 2020/11/21 0021下午 3:46
 * @description: TODO
 */
public class le645 {
    public int[] findErrorNums(int[] nums) {
        int a[] = new int[2];
        int len = nums.length;
        int sum = (1+len)*len/2;
        int k[]= new int[len+1];
        for(int i=0;i<len;i++){
            if(k[nums[i]]!=1) {
                sum -= nums[i];
            }else{
                a[0]=nums[i];
            }
        }
        a[1] = sum;
        return a;
    }
}
