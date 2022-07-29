package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/7/28 16:28
 * @Description TODO
 */
public class le2530 {
    public int shortestSequence(int[] rolls, int k) {
        int count = 0;
        int[] num = new int[k + 1];
        int k2 = 0;
        for (int i = rolls.length - 1; i >= 0; i--) {
            //开始打包
            int roll = rolls[i];
            if (num[roll] == 0) {
                num[roll] = 1;
                k2++;
            }

            if (k2 == k) {
                count++;
                Arrays.fill(num,0);
                k2=0;
            }
        }
        return count+1;
    }


    @Test
    public void t(){
        int [] rolls = {4,2,1,2,3,3,2,4,1};
        System.out.println(shortestSequence(rolls, 4));
    }
}
