package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le1566
 * @date 2021/1/27 0027上午 9:31
 * @description: TODO
 */
public class le1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        if(arr.length<m){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap();
        int j=0;
        while(j<m){
            sb.append(arr[j]+" ");
            j++;
        }
        map.put(sb.toString(),1);
        for(int i=m;i<arr.length;i++){
            sb.delete(0,2);
            sb.append(arr[i]+" ");
            int keys=map.getOrDefault(sb.toString(),0);
            keys++;
            if(keys==k){
                return true;
            }
            map.put(sb.toString(),keys);

        }
        return false;
    }

    @Test
    public void t(){
        containsPattern(new int[]{1,2,1,2,1,1,1,3},2,2);
    }
}
