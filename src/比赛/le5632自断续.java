//package 比赛;
//
//import org.junit.Test;
//
//import java.util.*;
//
///**
// * @author Hujf
// * @title: le5632自断续
// * @date 2020/11/29 0029上午 10:48
// * @description: TODO
// */
//public class le5632自断续 {
//    public int[] mostCompetitive(int[] nums, int k) {
//        if(nums.length==k){
//            return nums;
//        }
//        List<Integer> d = new LinkedList<>();
//        for (int i = 0; i < k ; i++) {
//            d.add(nums[i+nums.length-k]);
//
//        }
//        for (int i=nums.length-1 - k; i >= 0; i--) {
//            //比他xiao
//            if (nums[i] <= d.get(0)) {
//                //找后面是否有小的
//                int count = 1;
//                while (count < k) {
//                    if (d.get(count-1) > d.get(count)) {
//                        d.remove(count-1);
//                        d.add(0,nums[i]);
//                        break;
//                    }
//                    count++;
//                }
//                if(count==k){
//                    d.remove(d.size()-1);
//                    d.add(0,nums[i]);
//                }
//            }
//
//        }
//
//        return d.stream().mapToInt(Integer::valueOf).toArray();
//    }
//
//    @Test
//    public void t(){
//
//    }
//
//
//    public int[] mostCompetitive2(int[] nums, int k) {
//        int aim[] = new int[k];
//        List<Integer> d = new LinkedList<>();
//        int countnixu =0;
//        for (int i = 0; i < k ; i++) {
//            d.add(nums[i+nums.length-k]);
//        }
//        for(int i=0;i<d.size();i++){
//            for(int j=i+1;j<d.size();j++){
//                if(d.get(i)>d.get(j)){
//                    countnixu++;
//                }
//            }
//        }
//
//        for (int i=nums.length-1 - k; i >= 0; i--) {
//            //比他xiao
//            if (nums[i] <= d.get(0)) {
//                if(countnixu==0){
//                    d.remove(d.size()-1);
//                    d.add(0,nums[i]);
//                    continue;
//                }                //找后面是否有小的
//                int count = 1;
//                while (count < k) {
//                    if (d.get(count-1) > d.get(count)) {
//                        d.remove(count-1);
//                        d.add(0,nums[i]);
//                        countnixu--;
//                        break;
//                    }
//                    count++;
//                }
//                if(count==k){
//                    d.remove(d.size()-1);
//                    d.add(0,nums[i]);
//                }
//            }
//
//        }
//
//        aim = d.stream().mapToInt(Integer::valueOf).toArray();
//        return aim;
//    }
//}
