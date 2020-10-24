package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1480
 * @date 2020/10/24 0024下午 9:19
 * @description: TODO
 */
public class le1480 {
    public int countPrimes(int n) {        int count =0;
        int a[] =new int[n+1];
        for(int i=2;i<=n/2+1;i++){
            for(int j=2;j*i<=n;j++){
                a[i*j]=1;
            }
        }
        for(int i=2;i<n;i++){
            if(a[i]==0){
                System.out.println(i);
                count++;
            }
        }
        return count;

    }
    @Test
    public void t(){
        countPrimes(499979);
    }
}
