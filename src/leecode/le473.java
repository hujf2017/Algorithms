package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le473
 * @date 2020/9/16 0016上午 10:10
 * @description: TODO
 */
public class le473 {
    @Test
    public void makesquare() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            // return false;
        }
        int each = sum / 4;
        boolean isUsed[] = new boolean[nums.length];
        System.out.println(calc(each, isUsed, 0, nums, 0));
        a = false;
        System.out.println(calc(each, isUsed, 0, nums, 0));
        a = false;
        System.out.println(calc(each, isUsed, 0, nums, 0));
        a = false;
        System.out.println(calc(each, isUsed, 0, nums, 0));
    }
    boolean a = false;
    private boolean calc(int each, boolean[] isUsed, int sum, int[] nums, int k) {

        if (sum == each) {
             a = true;
        } else {
            boolean isuser = false;
            for (int i=k; i < isUsed.length; i++) {
                if (isUsed[i] == true) {
                    continue;
                }
                if (sum + nums[i] <= each) {
                    isuser = true;
                    isUsed[i] = true;
                    calc(each, isUsed, sum + nums[i], nums, i);
                    if(a==true){
                        break;
                    }
                }
            }
            if(isuser == false){
                isUsed[k]=false;
            }

        }
        return a;
    }
}
