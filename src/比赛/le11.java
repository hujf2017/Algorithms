package 比赛;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le11
 * @date 2020/11/14 0014下午 10:38
 * @description: TODO
 */
public class le11 {
    public int[] decrypt(int[] code, int k) {
        int n =code.length;
        int b[] =code.clone();
        if(k==0){
             Arrays.fill(code,0);
            return code;
        }else if(k>0){

            for(int i=0;i<n;i++){
                int count =0;
                int sum =0;
                while(count<k){
                    count++;
                    sum +=code[(i+count)%n];
                }
                b[i] = sum;
            }
            return b;
        }else{

            for(int i=0;i<n;i++){
                int count =0;
                int sum =0;
                while(count<-k){
                    count++;
                    sum +=code[(i+n-count)%n];
                }
                b[i] = sum;
            }
            return b;
        }
    }


    @Test
    public void t(){
        decrypt(new int[]{2,4,9,3},-2);
    }
}
