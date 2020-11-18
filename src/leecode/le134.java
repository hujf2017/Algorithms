package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le134
 * @date 2020/11/18 0018上午 9:04
 * @description: TODO
 */
public class le134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] left = new int[len];
        int sum = 0;

        for (int i = 0; i < len; i++) {
            left[i] = gas[i] - cost[i];
            sum += left[i];
        }
        if (sum < 0) {
            return -1;
        }
        //遍历left  求和sum2  如果出现小于0  找一个正数
        int sum2 = 0;
        int local = 0;
        int local2= local;
        while (true) {

            sum2 += left[local2];
            if (sum2 < 0) {
                local ++;
                local2 = local;
                sum2 = 0;
                continue;
            }else{
                local2=(local2+1)%len;
            }

            if (local2 == local) {
                break;
            }
        }
        return local;
    }

    @Test
    public void t(){
        canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }
}
