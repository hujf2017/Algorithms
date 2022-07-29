package leecode;

import javafx.collections.transformation.SortedList;
import org.junit.Test;

import java.sql.Array;
import java.util.*;

/**
 * @Author hujf
 * @Date 2022/7/28 11:29
 * @Description TODO
 */
public class le1331 {
    public int[] arrayRankTransform(int[] arr) {
        int [] snum = new int[arr.length];
        snum[0]=1;
        for(int i=1;i<arr.length;i++){
            int count =0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    count++;
                }else if(arr[i]==arr[j]){
                    snum[i]=snum[j];
                    break;
                }else {
                    arr[j]++;
                }
                snum[i] = count;
            }
        }
        return arr;
    }

    @Test
    public void t(){
        arrayRankTransform(new int[]{});
    }
}
