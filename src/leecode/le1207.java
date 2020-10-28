package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le1207
 * @date 2020/10/28 0028上午 9:53
 * @description: TODO
 */
public class le1207 {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length==0){
            return true;
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<Integer>();
        int count =0;
        int last = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==last){
                count ++;
            }else{
                if(set.contains(count)){
                    return false;
                }else{
                    set.add(count);
                    count = 1;
                    last =arr[i];
                }
            }
        }
        if(set.contains(count)){
            return false;
        }
        return true;
    }

    @Test
    public void t(){
        uniqueOccurrences(new int[]{1,2});
    }
}
