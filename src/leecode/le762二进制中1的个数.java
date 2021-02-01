package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le762
 * @date 2021/1/30 0030上午 10:55
 * @description: TODO
 */
public class le762二进制中1的个数 {

    public int countPrimeSetBits(int L, int R) {
        int count =0;
        for(int i=L;i<=R;i++){
            int m = Integer.bitCount(i);
            if(m==1){
                continue;
            }
            if(m==2||m==3){
                count++;
                continue;
            }
            int n =2;
            boolean is = true;
            while(n<m){
                if(m%n==0){
                    is=false;
                    break;
                }
                n++;
            }
            if(is){
                count++;
            }
        }
        return count;
    }

    @Test
    public void t(){
        countPrimeSetBits(15,15);
    }
}
