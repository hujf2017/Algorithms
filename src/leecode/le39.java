package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le39
 * @date 2020/9/9 0009下午 4:29
 * @description: TODO
 */
public class le39 {
    public static void main(String args[]){
        int []costs = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(combinationSum(costs,7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> a = new ArrayList();
        for(int i=0;i<candidates.length;i++){
           List a1 = calc(i,target);
           
           a.add(a1);
        }

        return a ;
    }

    private static List calc(int i, int target) {
        List a = new ArrayList();
        if(target == 0){
            return a ;
        }else if(target<0){

        }
        return a;
    }


}
