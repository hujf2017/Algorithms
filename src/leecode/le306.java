package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le306
 * @date 2020/9/5 0005下午 12:08
 * @description: TODO
 */
public class le306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i <= num.length() / 2; i++) {
            StringBuilder sbd = new StringBuilder(num);
            for (int j = 1; j <= num.length() / 2; j++) {
                long num1;
                long num2;
                long num3;
                long num4=-1;
                try {
                    num1 = Long.parseLong(sbd.substring(0, i));
                    num2 = Long.parseLong(sbd.substring(i, i + j));
                    num3 = Long.parseLong(sbd.substring(i + j, i + j * 2));
                    if((num1!=0&&String.valueOf(num1).length()!=i)){
                       continue;
                    }
                    if((num2!=0&&String.valueOf(num2).length()!=j)){
                        continue;
                    }
                    if((num3!=0&&String.valueOf(num3).length()!=j)){
                        continue;
                    }
                    if (i + j * 2+1 <= sbd.length()) {
                        num4 = Long.parseLong(sbd.substring(i + j, i + j * 2+1));
                    }
                } catch (Exception e) {
                    continue;
                }
                if (num1 + num2 == num3) {
                    if (dfs(0,i,i + j,i + j * 2,j, sbd)) {
                        return true;
                    }
                }
                if (num1 + num2 == num4&&String.valueOf(num4).length()==j+1) {
                    if (dfs(0,i, i + j,i + j * 2+1,j +1, sbd)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int fstart,int sestart,int endstart,int endend, int len, StringBuilder sbd) {
        if (endend == sbd.length()) {
            return true;
        }
        long num1;
        long num2;
        long num3;
        long num4=-1;
        try {
            num1 = Long.parseLong(sbd.substring(fstart, sestart));
            num2 = Long.parseLong(sbd.substring(sestart, endstart));
            num3 = Long.parseLong(sbd.substring(endstart, endend));

            if(String.valueOf(num1).length()!=sestart-fstart){
                return false;
            }
            if(String.valueOf(num2).length()!=endstart-sestart){
                return false;
            }
            if(String.valueOf(num3).length()!=endend-endstart){
                return false;
            }
            if (endstart + 1 <= sbd.length()) {
                num4 = Long.parseLong(sbd.substring(endstart, endend + 1));
            }
        } catch (Exception e) {
            return false;
        }

        if (num1 + num2 == num3) {
            if (dfs(sestart, endstart, endend,endend+len,len,sbd)) {
                return true;
            }
        }
        if (num1 + num2 == num4&&String.valueOf(num4).length()==len+1) {
            if (dfs(sestart, endstart, endend,endend+len,len+1,sbd)) {
                return true;
            }
        }
        return false;
    }



    @Test
    public void t() {
        isAdditiveNumber("199100199"
        );
    }
}
