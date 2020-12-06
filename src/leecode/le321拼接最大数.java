package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Hujf
 * @title: le321拼接最大数
 * @date 2020/12/2 0002下午 8:13
 * @description: TODO
 */
public class le321拼接最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Deque<Integer> d1 = new LinkedBlockingDeque<>();
        Deque<Integer> d2 = new LinkedBlockingDeque<>();
        Deque<Integer> d3 = new LinkedBlockingDeque<>();
        Deque<Integer> d4 = new LinkedBlockingDeque<>();

        int local1 = 1;
        int local2 = 1;
        d1.add(nums1[0]);
        d3.add(nums2[0]);
        while(local1<nums1.length){
            //把比他小的转移到另外一个队列中
            while(d1.size()>0&&nums1[local1]>d1.peekLast()){
                d2.add(d1.pollLast());
            }
            d1.add(nums1[local1]);
            local1++;
        }

        while(local2<nums2.length){
            //把比他小的转移到另外一个队列中
            while(d3.size()>0&&nums2[local2]>d3.peekLast()){
                d4.add(d3.pollLast());
            }
            d3.add(nums2[local2]);
            local2++;
        }

        int len1 = d1.size()+d3.size();
        int []num=null;
        if(len1>=k){
             num= getMax(d1,d3,k);
        }else{
            num = getMax2(d1,d2,d3,d4,k-len1,nums1,nums2);
        }
        return num;
    }

    private int[] getMax2(Deque<Integer> d1, Deque<Integer> d2, Deque<Integer> d3, Deque<Integer> d4, int need,int[] nums1, int[] nums2) {
        int i=0;
        while(i<need){
            if(d2.size()>0&&(d4.size()==0||d2.getLast()>d4.getLast())){
                d1 = calc(d1,nums1,d2.pollLast());
            }else{
                d3 = calc(d3,nums2,d4.pollLast());
            }
            i++;
        }

        return  getMax(d1,d3,d1.size()+d3.size());
    }

    private Deque<Integer> calc(Deque<Integer> d, int[] nums, Integer pollLast) {
        int local1 = 0;
        List<Integer> sa = new LinkedList<>(d);
        int count = 0;
        while(local1<nums.length){
            //把比他小的转移到另外一个队列中
            if(nums[local1]==pollLast){
                sa.add(count,pollLast);
                break;
            }
            if(sa.get(count) ==nums[local1]){
                count++;
            }
            local1++;
        }
        d = new LinkedList(sa);
        return d;
    }


    //拼接字符串
    private int[] getMax(Deque<Integer> d1, Deque<Integer> d3, int k) {
        int []a = new int[k];
        int nu =0;
        while(nu<k){
            if(d1.size()==0||d3.size()==0){
                break;
            }
            a[nu]= d1.getFirst()>d3.getFirst()?d1.pollFirst():d3.pollFirst();
            nu++;
        }
        //此时说明只需要从一边拿就行了
        while(nu<k) {
            if(d1.size()==0){
                a[nu] = d3.pollFirst();
            }else{
                a[nu] = d1.pollFirst();
            }
            nu++;
        }
        return a;
    }


    @Test
    public void t(){
        maxNumber(new int[]{6,7},new int[]{6,0,4},5);
    }

}
