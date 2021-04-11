package 排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: 基数排序
 * @date 2021/4/1114:25
 * @description: TODO
 */
public class 基数排序 {

    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};
    @Test
    public void method(){
        if (a.length <= 1) {
            return;
        }

        int max =0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max =a[i];
            }
        }

        //计算位数
        int count =0;
        while(max>0){
            max/=10;
            count++;
        }

        //申请一个桶
        int [][] buckets = new int[10][a.length];
        int base=10;

        //从低位到高位  分配
        for(int i=0;i<count;i++){
            int[] bktLen = new int[10];//默认都是0  10个桶

            for(int j=0;j<a.length;j++){
                int witchb = a[j]%base/(base/10);
                buckets[witchb][bktLen[witchb]] = a[j];
                //witchb 这个桶的数量+1
                bktLen[witchb]++;
            }


            //收集桶元素
            int k = 0;
            for(int b=0;b<buckets.length;b++){
                for(int p =0;p<bktLen[b];p++){
                    a[k++] = buckets[b][p];
                }
            }

            System.out.println("每次排序 "+ Arrays.toString(a));
            base*=10;
        }
    }
}
