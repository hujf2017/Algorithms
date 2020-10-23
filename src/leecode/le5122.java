package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le5122
 * @date 2020/10/17 0017下午 10:55
 * @description: TODO
 */
public class le5122 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int sum = 0;
        int count=0;
        for(int i = (int) (len*0.05)+1; i<=len*0.95; i++){
            sum+=arr[i];
            count++;
        }
        return (double)sum/count;

    }

    @Test
    public void t(){
        int a []= {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        trimMean(a);
    }

}
