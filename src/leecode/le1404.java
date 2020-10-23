package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1404
 * @date 2020/9/21 0021下午 8:54
 * @description: TODO
 */
public class le1404 {
    @Test
    public void numSteps() {
        String s = "10101010100111011";

            char a []= s.toCharArray();
            int num = 0;
            int  isOne = 0;
            int haone = 0;
            for(int i=a.length-1;i>=0;i--){

              if(a[i]=='1'){
                  haone++;
                  isOne++;
                  continue;
              }

              if(haone==0){
                  num = num+1;
                  isOne=0;
              }else {
                  num = num+isOne+1;
                  isOne = 1;
              }
            }
            if(haone==1){
                System.out.println(a.length-1);
            }
            System.out.println(num+isOne+1);
    }
}
