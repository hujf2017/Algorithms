package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/9/2 14:09
 * @Description 找所有的约数就行了
 */
public class le650 {
    public int minSteps(int n) {
        int count =0;
        int k=n;
        int num =2;
        while(k>1){
            while(k%num==0){
                k=k/num;
                count+=num;
            }
            num++;
        }

        return count;
    }

    @Test
    public void t(){
        System.out.println(minSteps(3));
    }
}
