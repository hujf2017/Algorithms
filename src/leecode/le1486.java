package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1486
 * @date 2021-05-07 20:38
 * @description: TODO
 */
public class le1486 {
    public int xorOperation(int n, int start) {
        int local =start +2;
        for(int i=0;i<n-1;i++){
            start=start^local;
        }
        return start;
    }

    @Test
    public void t(){
        xorOperation(5,0);
    }
}
