package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1539
 * @date 2020/10/19 0019下午 8:11
 * @description: TODO
 */
public class le1539 {
    public int findKthPositive(int[] arr, int k) {
        int count =0;
        int last=0;
        for(int ks:arr){
            count+=ks-last-1;
            if(count>=k){
                System.out.println(ks - count+k-1);
                return ks - count+k-1;
            }
            last =ks;
        }
        System.out.println(last+ k-count);
        return last+ k-count;
    }

    @Test
    public void t(){
        findKthPositive(new int[]{3},2);
    }

}
