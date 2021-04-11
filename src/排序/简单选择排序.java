package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 简单选择排序
 * @date 2021/4/1111:19
 * @description: pai'ge
 */
public class 简单选择排序 {

    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};
    @Test
    public void method(){
        for(int i=0;i<a.length;i++){
            int max =i;
            for(int j=i;j<a.length;j++){
                if(a[j]>a[max]){
                    max=j;
                }
            }
            if(max!=i){
                int tmp = a[max];
                a[max] = a[i];
                a[i]=tmp;
            }
        }

        for(int num:a){
            System.out.print(num+"\t");
        }
    }
}
