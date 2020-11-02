package 比赛;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le1031
 * @date 2020/10/31 0031下午 10:22
 * @description: TODO
 */
public class le1031 {
    public int[] frequencySort(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> m = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i],m.get(nums[i])+1);
            }else{
                m.put(nums[i],1);
            }
        }
        List<Numsort> a = new ArrayList();
        int nums2[] =new int[nums.length];
        for(Map.Entry<Integer,Integer> am :m.entrySet()){
            a.add( new Numsort(am.getKey(),am.getValue()));
        }

        Collections.sort(a);
        int lastx = 0;
        for(int i =0;i<a.size();i++){
            Numsort sd = a.get(i);
            for(int j=0;j<sd.time;j++){
                nums2[lastx] =sd.num;
                lastx++;
            }
        }
        return nums2;
    }

    class Numsort implements Comparable<Numsort>{
         public int num;
        public int time;
        public Numsort(int num ,int time){
            this.num=num;
            this.time = time;
        }
        @Override
        public int compareTo(Numsort o) {
            if(o.time-this.time>0){  //比较前一个和当前这个 ，如果前面的大 返回-1 就是交换位置
                return -1;
            }else if(o.time-this.time<0){
                    return 1;
            }else{
                return o.num-this.num;//比较前一个和当前这个 前面的大 正 不交换 即倒叙
            }
        }
    }
    @Test
    public void t(){
        frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
    }
}
