package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le374
 * @date 2020/11/11 0011下午 5:16
 * @description: TODO
 */
public class le374 {
    long num = -1;
    long low = 1;
    long high ;
    public int guessNumber(int n) {
        if(guess(n)==0){
            return n;
        }

        high = n;
        calc(low/2+high/2);
        return (int)num;
    }
    private void calc(long n) {
        if(num!=-1){
           return ;
        }
        int k = guess((int)n);
        if( k==0){
            num =n;
        }else {
            if(k==-1){
                high = n;
                calc((low+high)/2);
            }else{
                low =n;
                calc((low+high)/2);
            }

        }
    }
    int pick = 1702766719;
    private int guess(int n) {
        if (n > pick) {
            return -1;
        } else if (n < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    @Test
    public void t(){
        guessNumber(2126753390);
    }

}
