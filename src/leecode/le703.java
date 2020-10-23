package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: le703
 * @date 2020/10/23 0023上午 9:28
 * @description: TODO
 */
public class le703 {
    private int local ;
    List<Integer> kspp = new LinkedList<Integer>();
    public le703(int k, int[] nums) {
        this.local = k;
        Arrays.sort(nums);
        for(int i=0;i<k&&i<nums.length;i++){
            kspp.add(nums[nums.length-1-i]);
        }
        while(kspp.size()<local){
            kspp.add(Integer.MIN_VALUE);
        }
    }

    public int add(int val) {
        int asd=0;
        for(int i:kspp){
            if(val>=i){
                kspp.add(asd,val);
                kspp.remove(local);
                break;
            }
            asd++;
        }
         return kspp.get(local - 1);
    }

    @Test
    public void t(){
        le703 aasd = new le703(1, new int[]{});
        System.out.println(aasd.add(-3));
        System.out.println(aasd.add(-2));
        System.out.println(aasd.add(-4));
        System.out.println(aasd.add(0));
        System.out.println(aasd.add(4));
    }
}

