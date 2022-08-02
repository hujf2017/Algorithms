package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/2 15:04
 * @Description TODO
 */
public class le274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count =citations.length-1;
        int h =0;
        while(count>=0&&citations[count]>h){
            count--;
            h++;
        }
        return h;
    }

    @Test
    public void t(){
        System.out.println(hIndex(new int[]{0}));
    }
}
