package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hujf
 * @title: le04
 * @date 2020/9/23 0023下午 4:08
 * @description: TODO
 */
public class le04 {

    public static void main(String args[]){
        int a [] = {};
        int b[] = {1};

        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int all = nums1.length+nums2.length;
        int a1 = nums1.length;
        int a2 = nums2.length;
        int local1 = 0;
        int local2 = 0;

        int count = 0;

        if(nums1.length==0&&nums2.length==0){
            return 0;
        }

        if(nums1.length==0){
            nums1= new int[]{Integer.MAX_VALUE};
        }

        if(nums2.length==0){
            nums2= new int[]{Integer.MAX_VALUE};
        }

        if(all%2==0){
            int num = 0;

            while(count<=all/2 ){

                if(nums1[local1]<nums2[local2]){
                    if(count==all/2 -1){
                        num+=nums1[local1];
                    }


                    if(   count==all/2){
                        num+=nums1[local1];
                    }
                    count++;
                    local1++;
                    if(local1==a1){
                        local1--;
                        nums1[local1] = Integer.MAX_VALUE;
                        continue;
                    }
                }else{

                    if(count==all/2 -1){
                        num+=nums2[local2];
                    }

                    if(count==all/2){
                        num+=nums2[local2];
                    }
                    count++;
                    local2++;
                    if(local2==a2){
                        local2--;
                        nums2[local2] = Integer.MAX_VALUE;
                        continue;
                    }
                }
            }
            return (double)num/2;
        }else{
            int num = 0;
            while(count<=all/2 ) {
                if (nums1[local1] < nums2[local2]) {

                    if (count == all / 2) {
                        num += nums1[local1];
                    }

                    count++;
                    local1++;
                    if(local1==a1){
                        local1--;
                        nums1[local1] = Integer.MAX_VALUE;
                        continue;
                    }
                } else {

                    if (count == all / 2) {
                        num += nums2[local2];
                    }
                    count++;
                    local2++;
                    if(local2==a2){
                        local2--;
                        nums2[local2] = Integer.MAX_VALUE;
                        continue;
                    }
                }
            }
            return num;

        }
    }


    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int aim;
        int len  = nums1.length +nums2.length ;
        int len2 = len/2;
        int last ;
        for(int i=0, j=0;i+j<len2;){
            if(nums1[i]<nums2[j]){
                last = nums1[i];
                i++;
            }else{
                last = nums2[j];
                j++;
            }
        }
        return 1.0;
    }
}
