package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le1018
 * @date 2021/1/14 0014下午 6:36
 * @description: TODO
 */
public class le1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> l = new ArrayList<>();
        long sum = 0;
        for (int i : A) {
            /**
             * 5 10 15
             * 101  000   1010
             */
            sum = sum*2+i;
            sum = sum%10;
            if(sum%5==0){
                l.add(true);
            }else{
                l.add(false);
            }
        }
        return l;
    }

    @Test
    public void t(){
        prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1});
    }
}
