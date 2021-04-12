package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1818
 * @date 2021/4/1216:16
 * @description: TODO
 */
public class le1818 {
    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        int max= 0;
        int res =-1;

        int k[]= new int[nums1.length];
        long count =0;
        for(int i=0;i<nums1.length;i++){
            int num = Math.abs(nums1[i]-nums2[i]);

            count+=num;
            if(num>max){
                max = num;
                res = i;
            }
        }

        if(res==-1){
            return (int)count;
        }else{
            //查找差值最大的
            int s = nums2[res];
            int min = max;
            for(int i=0;i<nums1.length;i++){
                int num = Math.abs(nums1[i]-s);
                if(num<min){
                    min = num;
                }
            }
            return (int)(count -max+min)%  (1000000000 + 7);
        }
    }

    @Test
    public void t(){
        System.out.println(minAbsoluteSumDiff(new int[]{150,100},new int[]{90,10}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int num[] = new int[100001];

        for(int i=0;i<nums1.length;i++){
            num[nums1[i]]  = 1;
        }
        int count =0;
        int max =0;
        for(int i=0;i<nums1.length;i++){
            int s = Math.abs(nums1[i]-nums2[i]);
            //去1里面找 和2 最接近的 减去
            int num11 = find(num,nums2[i]);
            int tmp = Math.abs(s-num11);
            if(tmp>max){
                max = tmp;
            }
            count+=s;
        }
        return (count-max)%(1000000000+7);
    }

    private int find(int[] num, int k) {
        int i=0;
        int j=0;
        boolean get1 =false;
        boolean get2 =false;
        while(k+i<num.length){
            if( num[k+i]==1){
                get1=true;
                break;
            }
            i++;
        }

        while(k-j>0){
            if( num[k-j]==1){
                get2=true;
                break;
            }
            j++;
        }
        if(!get1){
         return j;
        }
        if(!get2){
            return i;
        }
        int max =Math.min(i,j);
        return max;
    }
}
