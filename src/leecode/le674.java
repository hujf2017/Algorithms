package leecode;

/**
 * @author Hujf
 * @title: le674
 * @date 2020/9/23 0023上午 10:56
 * @description: TODO
 */
public class le674 {
    public static void main(String args[]){
        int a[] =new int[]{};
       int k =  findLengthOfLCIS(a);
        System.out.println(k);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int count = 0;
        int lastCount= 0;
        if(nums.length==0){
            return 0;
        }
        int last  = nums[0];
        for(int a :nums ){
            if(a>last){
                count++;
            }else{
                if(count>lastCount){
                    lastCount = count;
                }
                count = 0;
            }
            last = a;
        }
        if(count>lastCount){
            lastCount = count;
        }
        return lastCount+1;
    }

}
