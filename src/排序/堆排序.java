package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 堆排序
 * @date 2021/4/1113:15
 * @description:
 */
public class 堆排序 {

    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};
    @Test
    public void method(){
        //注意细节 这个地方不到最后一个数字
        for(int i=a.length-1;i>0;i--){
            max_heapify(a,i);

            System.out.print(a[0]+"\t");
            //全部调整完之后，需要第一个和第i个人交换
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;


        }
        System.out.print(a[0]+"\t");
    }

    private void max_heapify(int[] a, int i) {
        int childLeft;
        //交换所有子堆  使得变成小顶堆  先冲i这个节点的父节点开始算  i的父节点 i-1 /2
        for(int local =(i-1)/2;local>=0;local--){
            childLeft=local*2+1;
            //如果存在右孩子，并且右孩子比做孩子还要小,就用右节点换上去
            if(childLeft<i&&a[childLeft]>a[childLeft+1]){
                childLeft++;
            }
            //交换父节点和子节点
            if(a[local]>a[childLeft]){
                int tmp =a[local];
                a[local]=a[childLeft];
                a[childLeft]=tmp;
            }
        }
    }
}
