package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le506
 * @date 2021/2/1 0001下午 12:43
 * @description: TODO
 */
public class le506 {
    public String[] findRelativeRanks(int[] nums) {
        int []k = nums.clone();
        Arrays.sort(k);
        Map<Integer,Integer> a = new HashMap();
        for(int i=0;i<k.length;i++){
            a.put(k[i],nums.length-i);
        }
        String []s = new String[nums.length];
        int asd=0;
        for(int i:nums){
            int num = a.get(i);
            if(num==1){
                s[asd]="Gold Medal";
            }else if(num==2){
                s[asd]="Silver Medal";
            }else if(num==3){
                s[asd]="Bronze Medal";
            }else{
                s[asd]=a.get(i)+"";
            }
            asd++;
        }
        return s;
    }
    @Test
    public void t(){
        findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
