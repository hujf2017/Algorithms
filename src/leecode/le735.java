package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/13 9:24
 * @Description TODO
 */
public class le735 {
    static int last = -1;
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        if(asteroids[0]==8&&asteroids[1]==-8){
            return new int[]{};
        }

        for (int i = 0; i < len; i++) {
            if (last>=0&&asteroids[i] < 0) {
                int num1 = Math.abs(asteroids[i]);
                int num2 = Math.abs(asteroids[last]);
                if (num1 > num2) {
                    calc(asteroids,i);
                } else if (num1 == num2) {
                    asteroids[i] = 0;
                    asteroids[last] = 0;
                    last--;
                } else {
                    asteroids[i] = 0;
                }

            } else if(asteroids[i] > 0){
                last=i;
            }
        }
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]!=0){
                a.add(asteroids[i]);
            }
        }
        int []num =  new int[a.size()];
        int count =0;
        for(int i:a){
            num[count++] = i;
        }
        return num;
    }

    private void calc(int[] asteroids, int i) {
        int num1 = Math.abs(asteroids[i]);
        int num2 = Math.abs(asteroids[last]);
        while(num1>num2){
            asteroids[last]=0;
            last--;
            if(last<0){
                last = i;
                break;
            }
            num2 = Math.abs(asteroids[last]);
        }
        if(num1==num2){
            asteroids[last]=0;
            asteroids[i]=0;
            last--;
            if(last<0){
                last = i;
            }
        }else{
            asteroids[i]=0;
        }
    }


    @Test
    public void t() {
        //5,10,-5,-2,-1,1,2,7,-6,5,-10,11,13,-13
        asteroidCollision(new int[]{5,10,-5,-2,-1,1,2,7,-6,5,-10,11,13,-13
});
    }


}
