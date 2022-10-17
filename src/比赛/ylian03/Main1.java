package 比赛.ylian03;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/14 17:31
 * @Description TODO
 */
public class Main1 {
    public int storedEnergy(int storeLimit, int[] power, int[][] supply) {
        int[] powerIndex = new int[power.length];

        int start = 0;
        int x;
        for ( x= 1; x < supply.length; x++) {
            int time = supply[x][0];
            while (start < time) {
                powerIndex[start++] = x - 1;
            }
        }
        while(start<power.length){
            powerIndex[start++] = x - 1;
        }

        int count = 0;
        for (int i = 0; i < power.length; i++) {
            int num = power[i];
            int sus = powerIndex[i];
            if (num - supply[sus][2] > 0) {
                count += num - supply[sus][2];
                if (count > storeLimit) {
                    count = storeLimit;
                }
            } else if (num - supply[sus][1] < 0) {
                count += num - supply[sus][1];
                if (count < 0) {
                    count = 0;
                }
            }
        }
        return count;
    }

    @Test
    public void t() {
        storedEnergy(10, new int[]{100000,100000}, new int[][]{{0, 9, 9}});
    }
}
