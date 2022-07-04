package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le39
 * @date 2020/9/9 0009下午 4:29
 * @description: TODO
 */
public class le39 {

    int []num = new int[201];
    List<List<Integer>> list = new ArrayList<>();
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {


        for(int i=0;i<candidates.length;i++){
            num[candidates[i]] =  1;
        }
        List <Integer> lis= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(target,candidates,lis,0);

        return list;
    }

    private void dfs(int target, int[] candidates,List lists,int begin) {
        if(target<0){
            return;
        }else if(target ==0){
            list.add(new ArrayList<>(lists));
        }else {
            for(int i=begin;i<candidates.length;i++){
                lists.add(candidates[i]);
                dfs(target-candidates[i],candidates,lists,i);
                lists.remove(lists.size()-1);
            }
        }
    }


    @Test
    public void t(){
        combinationSum(new int[]{100,200,4,1,
},400);
    }


}
