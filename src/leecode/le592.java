package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/7/27 9:30
 * @Description 分数计算
 */
public class le592 {
    public String fractionAddition(String expression) {
        StringBuilder sbd = new StringBuilder(expression);
        long num1;
        long num2;
        if (expression.startsWith("-")) {
            num1 = Integer.valueOf(sbd.substring(0, 2));
            num2 = Integer.valueOf(sbd.substring(3, 4));
            sbd.delete(0, 4);
        } else {
            num1 = Integer.valueOf(sbd.substring(0, 1));
            num2 = Integer.valueOf(sbd.substring(2, 3));

            sbd.delete(0, 3);
        }
        int fu;
        int zheng = -1;
        while ((fu = sbd.indexOf("-")) != -1 || (zheng = sbd.indexOf("+")) != -1) {
            int num3;
            int num4;



            if (fu != -1 && (fu < zheng || zheng == -1)) {
                if(sbd.substring(1, 3).equals(10)){
                    num3 = Integer.valueOf(sbd.substring(0, 3));
                }else{
                    num3 = Integer.valueOf(sbd.substring(0, 2)) ;
                }
               ;
                num4 = Integer.valueOf(sbd.substring(3, 4));
                sbd.delete(0, 4);
            } else {
                num3 = Integer.valueOf(sbd.substring(0,2));
                num4 = Integer.valueOf(sbd.substring(3, 4));
                sbd.delete(0, 4);
            }
            num1 = num1 * num4 + num3 * num2;
            num2 = num2 * num4;
        }

        long numx = calc(num1, num2);

        num1 = num1 / numx;
        num2 = num2 / numx;
        return num1 + "/" + num2;
    }

    private long calc(long num1, long num2) {
        long max = Math.max(Math.abs(num1), Math.abs(num2));
        long min = Math.min(Math.abs(num1), Math.abs(num2));
        long tmp;
        if (min == 0) {
            return max;
        }
        while (max % min != 0) {
            tmp = min;
            min = max % min;
            max = tmp;
        }
        return min;
    }

    @Test
    public void t() {
        fractionAddition("-5/2+10/3+7/9");
    }

}


