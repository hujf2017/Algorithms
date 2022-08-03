package leecode;

/**
 * @Author hujf
 * @Date 2022/8/3 10:02
 * @Description TODO
 */
public class le421 {
    public int findMaximumXOR(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i]^nums[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int num = 5 ^ 25;
        System.out.println(num);
    }
}
