package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le605
 * @date 2021/1/1 0001下午 2:51
 * @description: TODO
 */
public class le605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int count0 = 0;
        int i = 0;
        for (; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                int num = count0 / 2;
                n -= num;
                if (n == 0) {
                    return true;
                }
                count0 = 0;
                break;
            } else {
                count0++;
            }
        }
        if(count0==flowerbed.length){
            if((count0+1)/2>=n){
                return true;
            }else{
                return false;
            }
        }
        for (; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                int num = (count0 - 1) / 2;
                n -= num;
                if (n == 0) {
                    return true;
                }
                count0 = 0;
            } else {
                count0++;
            }

        }
        if (count0 / 2 >= n) {
            return true;
        }
        return false;

    }


    @Test
    public void t(){
        canPlaceFlowers(new int[]{0,0,0},2);
    }
}
