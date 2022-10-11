package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/10 11:34
 * @Description 恰好只出现1次的2个数据
 */
public class le260 {
    public int[] singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        //找到最高位为1的 说明 俩值在这里不同  进行分组
        int wei = get(num);

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (panduan(nums[i],wei)) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }
        }

        int [] a =new  int [2];
        a[0] = num1;
        a[1] = num2;
        return a;
    }

    /**
     * 判断wei是否为1
     * @param num
     * @param wei
     * @return
     */
    private boolean panduan(int num, int wei) {
        while(wei>1){
            num= num>>1;
            wei--;
        }
        if(num%2==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 找到位置
     *
     * @param num
     * @return
     */
    private int get(int num) {
        int count = 1;
        while (num % 2 == 0) {
            count++;
            num = num / 2;

        }
        return count;
    }
    @Test
    public  void t() {
        System.out.println(1^1);
        System.out.println(singleNumber(new int[]{1,2,1,3,2,5}));
    }
}
