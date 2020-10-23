package 比赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: 目标和
 * @date 2020/9/23 0023下午 5:26
 * @description: TODO
 */
public class 目标和 {

    public static void main(String args[]){
        int a[] = {1, 5, 6, 7, 3, 5, 2};
        int target =11;
        findMedianSortedArrays(a,target);
    }

    public static int[][] findMedianSortedArrays(int[] nums1, int target) {


        int a[][] =new int[][]{};
        for(int i=0;i<nums1.length;i++) {
            boolean[] isVisit = new boolean[nums1.length];
            isVisit[i] = true;
            int x[][] = calc(i, target,nums1[i],nums1,isVisit,nums1[i]+"");
        }
        return null;
    }
    private static int[][] calc(int i, int target,int sum,int[] nums1,boolean[] isv,String s) {
        if(sum == target){
            System.out.println(s);
            return null;
        }
        if(sum > target){
            return null;
        }
        for(int j=i;j<nums1.length;j++){
            if(isv[j]==true){
                continue;
            }
            isv[j] = true;
            calc(j,target,sum+nums1[j],nums1, isv,s+" + "+nums1[j]);
            isv[j] = false;
        }
        return null;
    }


}
