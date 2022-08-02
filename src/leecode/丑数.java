package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/2 11:00
 * @Description TODO
 */
public class 丑数 {
    boolean[] num = new boolean[4000];

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        num[1] = true;



        calc(2 );
        calc(3 );
        calc(5 );
        int j=1;
        while(n>0){
            if(num[j++]==true){
                n--;
            }
            if(n==0){
                break;
            }
        }
        return j-1;
    }

    private void calc(int i) {
        int count = 1;
        int nx=i*count;
        while (nx < 1691) {
            count++;
            if(num[nx]){
                nx = i*count;
                continue;
            }
            num[nx] = true;
            nx = i*count;
        }
    }


    @Test
    public void t(){
        nthUglyNumber(15);
    }
}
