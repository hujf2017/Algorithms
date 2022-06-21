package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/6/17 9:38
 * @Description TODO
 */
public class le1089 {
    public void duplicateZeros(int[] arr) {
        List<Integer> a = new LinkedList();
        for(int i:arr){
            if(i==0){
                a.add(i);
                a.add(i);
            }else{
                a.add(i);
            }
        }
        for(int i=0;i<arr.length ;i++){
            arr[i] = a.get(i);
        }

    }

    public void duplicateZeros2(int[] arr) {
        int last =0;
        int len = arr.length;
        for(int i=0;i<arr.length ;i++){
           if(arr[i]==0){
               if(i+1<len){
                   last =arr[i+1];
                   arr[i+1] = 0;
               }

           }
        }

    }
}
