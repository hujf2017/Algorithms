package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 冒泡
 * @date 2021/4/1114:02
 * @description: TODO
 */
public class 冒泡 {
    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};

    @Test
    public void method(){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]<a[j+1]){
                    int tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        for(int num:a){
            System.out.print(num+"\t");
        }
    }
}
