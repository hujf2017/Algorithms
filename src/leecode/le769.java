package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/19 10:32
 * @Description TODO
 */
public class le769 {

    public int maxChunksToSorted(int[] arr) {
        int Max =0;
        int count =0;
        for(int i=0;i<arr.length;i++){
            int k = arr[i];
            Max = Math.max(k ,Max);
            if(Max ==i){
                count++;
            }
        }
        return count;
    }


    @Test
    public void t(){
        maxChunksToSorted(new int[]{1,0,2,3,4});
    }
}
