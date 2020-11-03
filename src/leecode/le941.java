package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le941
 * @date 2020/11/3 0003下午 4:15
 * @description: TODO
 */
public class le941 {
    public boolean validMountainArray(int[] A) {
        if(A.length<3|| A[0]>A[1]){
            return false;
        }
        int max = A[1];
        int i=2;
        for(;i<A.length;i++){
            if(A[i]==max){
                return false;
            }
            if(A[i]<max){
                break;
            }
            max =A[i];
        }

        if(i>=A.length){
            return false;
        }
        for(;i<A.length;i++){
            if(A[i]>=max){
                return false;
            }
            max =A[i];
        }
        return true;
    }


    @Test
    public void t(){
        validMountainArray(new int[]{1,7,9,5,4,1,2});
    }
}
