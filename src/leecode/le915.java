package leecode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le915
 * @date 2020/11/2 0002下午 6:52
 * @description: 一个数组，切一刀  左边的比右边的都小 且左边和右边不能有相交
 */
public class le915 {
    public int partitionDisjoint(int[] A) {
        //左边的数据记录下 最大的
        int max = A[0];
       // Set set = new HashSet<>();
        boolean isok = true;
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max = A[0];
            }
          //  set.add(A[i]);
            for(int j=i+1;j<A.length;j++){
                if(A[j]<max){
                    isok =false;
                    break;
                }
            }
            //如果不ok 下一个i;
            if(!isok){
                isok = true;
                continue;
            }else{
                return i+1;
            }
        }
        return 0;
    }

    @Test
    public void t(){
        partitionDisjoint(new int[]{32,57,24,19,0,24,49,67,87,87});
    }
}
