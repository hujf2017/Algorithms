package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 堆排序
 * @date 2021/4/1113:15
 * @description: 排个大顶堆
 */
public class 堆排序 {


    @Test
    public void method() {
        int[] a = new int[]{4, 9, 7, 1, 8, 5};
        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);
            System.out.println(a[0]);
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
        }
        System.out.println(a[0]);
    }
    //直接大堆
    private void max_heapify(int[] a, int i) {
        int num ;

        //循环找到
        for (int local = (i - 1) / 2; local >= 0; local--) {
            num = local*2+1;
            //判断这个节点是否有兄弟节点  取最大的
            if(num<i&&a[num]>a[num+1]){
                num = num+1;
            }

            //和上面的父节点进行交换
            if(a[num]<a[local]){
                int tmp = a[local];
                a[local] = a[num];
                a[num] = tmp;
            }
        }
    }
}
