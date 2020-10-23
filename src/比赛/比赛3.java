package 比赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: 比赛3
 * @date 2020/9/5 0005下午 11:31
 * @description: TODO
 */
public class 比赛3 {
    public static void main(String args[]){
        // int a[][] = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int s[] = {13,0,14,7,18,18,18,16,8,15,20};
        System.out.println(findLengthOfShortestSubarray(s));

    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int count = 0;
        boolean is= false;
        List<Integer> a = new ArrayList<>();
        if(arr.length==1){
            return 0;
        }
        for(int i=0;i<arr.length;i++){
            a.add(arr[i]);
        }
        int s = 0;
        for(int i=1;i<a.size()-1;i++){
           if(a.get(i)<a.get(i-1)){

               for(int j=0;j<=s;j++){
                   a.remove(i-j);

               }
               i=i-s-1;
               is=true;
               count =count +s+1;
               s = 0;
               continue;
           }
           if(is){
               s++;
           }
        }
        return count;
    }
}
