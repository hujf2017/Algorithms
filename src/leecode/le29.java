package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/22 14:28
 * @Description TODO
 */
public class le29 {
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        boolean zup1 = dividend>0;
        boolean zup2 = divisor>0;
        //与操作  相同为f
        int count =0;
        if(zup1){
            if(zup2){
                while(dividend>=0){
                    count++;
                    dividend-=divisor;
                }
                if(count==2147483647){
                    return 2147483647;
                }
                return count-1;

            }else{
                while(dividend>=0){
                    count++;
                    dividend+=divisor;
                }
                if(count==-2147483648){
                    return -2147483648;
                }
                return 1-count;
            }
        }else{
            if(zup2){
                while(dividend<=0){
                    count++;
                    dividend+=divisor;
                }
                if(count==-2147483648){
                    return -2147483648;
                }
                return 1-count;
            }else{
                while(dividend<=0){
                    count++;
                    dividend-=divisor;
                }
                if(count==2147483647){
                    return 2147483647;
                }
                return count-1;
            }
        }
    }



    @Test
    public void t(){
        System.out.println(divide(1,1));
    }
}
