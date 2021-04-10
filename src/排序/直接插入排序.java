package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 直接插入排序
 * @date 2021/4/1016:18
 * @description: TODO
 */
public class 直接插入排序 {

    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};


    @Test
    public void Method(){
        for(int i=1;i<a.length;i++){
            int j;
            int num = a[i];
            for(j=i;j>=0&&a[j-1]>num;j--){
                a[j] =a[j-1];
            }
            a[j]=num;
        }
        for(int s:a){
            System.out.print(s+"\t");
        }
    }
}
