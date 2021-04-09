package leecode;

/**
 * @author Hujf
 * @title: le154
 * @date 2021/4/914:14
 * @description: TODO
 */
public class le154 {

    public int findMin(int[] nums) {
        int num = Integer.MAX_VALUE;
        for(int numin:nums){
            if(numin<num){
                num = numin;
            }
        }
        return num;
    }
}
