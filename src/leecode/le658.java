package leecode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author hujf
 * @Date 2022/8/25 9:12
 * @Description TODO
 */
public class le658 {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index =0;
        while(index<arr.length&&arr[index]<x){
            index++;
        }

        int index2 = index-1;
        Deque<Integer> deque = new LinkedList();
        while(deque.size()<k){
            if(index2>=0&&index<arr.length){
                if(arr[index]-x>=x-arr[index2]){
                    deque.addFirst(arr[index2]);
                    index2--;
                }else {
                    deque.add(arr[index]);
                    index++;
                }

            }else if(index2>=0){
                //到上限
                deque.addFirst(arr[index2]);
                index2--;
            }else {
                // 因为 k<=len  到下限
                deque.add(arr[index]);
                index++;
            }
        }
        List<Integer> collect = deque.stream().collect(Collectors.toList());
        return collect;
    }


    @Test
    public void t(){
        findClosestElements(new int[]{3,5,8,10},2,15);
    }
}
