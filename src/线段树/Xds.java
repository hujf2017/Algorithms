package 线段树;

import java.util.Scanner;
public class Xds {
    //线段树的实现    我们都是默认从下标为1开始的  编号寻找为左节点2*i  右节点为2*i+
    //线段树节点（用于建立线段树节点对象数组）
   static class Tree{
        int left;//记录当前节点左边界
        int right;//记录当前节点又边界
        int max;//记录当前节点的最大值
        int sum;//记录当前节点的所有和
        public Tree() {

        }
        @Override
        public String toString() {
            return "Tree{" +
                    "left=" + left +
                    ", right=" + right +
                    ", max=" + max +
                    ", sum=" + sum +
                    '}';
        }
    }
    //构建线段树
    public static void build(int u,int left,int right,int[] a,Tree[] trees){//建立线段树函数   u表示当前节点的编号 a表示要建立线段树的原数组
        trees[u].left=left;//当前节点的左边界
        trees[u].right=right;//当前节点的又边界
        if(left==right){//表示到达了叶子节点
           trees[u].max=a[left];
           trees[u].sum=a[left];
           return;
        }else {
            if(left==4){
                int num =1;
            }
            int mid = (left + right) >>1;//计算中点的坐标
            build(2 * u, left, mid, a, trees);//递归解决所有节点信息
            build(2 * u + 1, mid + 1, right, a, trees);
            trees[u].max = Math.max(trees[2 * u].max, trees[2 * u + 1].max);//记录当前节点的最大值
            trees[u].sum=trees[2*u].sum+trees[2*u+1].sum;//记录当前节点的left和right之间的sum和
        }
    }
    //查找线段树指定范围之间的最大值
    public static int getMax(int left,int right,Tree[] trees,int u){//u表示当前节点的位置
       int mid=(trees[u].left+trees[u].right)>>1;
       //递归出口  到达叶子节点或者左右节点包含的情况下
       if (trees[u].left==trees[u].right||(left<=trees[u].left&&right>=trees[u].right)) return trees[u].max;
       if(right<=mid){//如果右边界小于中点的标号，则走左边界
           return getMax(left,right,trees,2*u);
       }else if (left>mid){//如果左边界大于中点的标号，则走右边界
           return getMax(left,right,trees,2*u+1);
       }else {
           int temp=getMax(left,mid,trees,2*u);//找到左边的最值
           int temp1=getMax(mid+1,right,trees,2*u+1);//找到右边的最值
           return Math.max(temp,temp1);
       }
    }
    //查找线段树指定范围之间的所有和
    public static int getSum(int left,int right,Tree[] trees,int u){
        int mid=(trees[u].left+trees[u].right)>>1;
        //递归出口  到达叶子节点或者左右节点对应相等的情况下
        if (trees[u].left==trees[u].right||(left==trees[u].left&&right==trees[u].right)) return trees[u].sum;
        if(right<=mid){//如果右边界小于中点的标号，则走左边界
            return getSum(left,right,trees,2*u);
        }else if (left>mid){//如果左边界大于中点的标号，则走右边界
            return getSum(left,right,trees,2*u+1);
        }else {
            int temp=getSum(left,mid,trees,2*u);//找到左边的所有和
            int temp1=getSum(mid+1,right,trees,2*u+1);//找到右边的所有和
            return temp+temp1;
        }
    }
    //寻找下标为index的元素在trees中的下标
    public static int getIndex(int index,Tree[] trees,int u){ //u表示trees的当前节点的下标 初始值为1
       //递归出口
        if (trees[u].left==index&&trees[u].right==index){//左右边界值相等
            return u;//返回在trees数组中的下标
        }
        int left=trees[u].left;//找到当前节点左边界
        int right=trees[u].right;//找到当前节点的有边界
        int mid=(left+right)>>1;
        if (index<=mid){//找到左边边界
            return getIndex(index,trees,2*u);
        }else return getIndex(index,trees,2*u+1);
    }
    //修改线段树内容(点更新)
    public static void update(int index,int value,Tree[] trees,int u){//将下标为index的值转换为value  u表示trees的当前节点的下标 初始值为1
       int i=getIndex(index,trees,u);//找到index的对应trees数组中的下标
       trees[i].max=value;//更新其叶子节点的max和value值
       trees[i].sum=value;
       i=i>>1;
       while (i>=u){//若i变为根节点的编号u，则退出循环 向上回溯解决修改节点值
           trees[i].max=Math.max(trees[2*i].max,trees[2*i+1].max);
           trees[i].sum=trees[2*i].sum+trees[2*i+1].sum;
           i=i>>1;
       }
    }
    //测试
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//输入数组的大小
        int[] a=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            a[i]=scanner.nextInt();
        }
        Tree[] trees=new Tree[4*n];//空间开4倍的数组长度大小
        for (int i = 0; i <4*n ; i++) {//防止空指针 所以需要每个都进行初始化
           trees[i]=new Tree();
        }
         build(1,1,n,a,trees);
        for (int i = 1; i <4*n ; i++) {
            System.out.println(trees[i].toString());
        }
        System.out.println("index "+getIndex(2,trees,1));
        System.out.println("max "+getMax(1,3,trees,1));
        System.out.println("sum "+getSum(1,4,trees,1));
        update(2,5,trees,1);//将元素组a的下标为2的值改为5
        for (int i = 1; i <4*n ; i++) {
            System.out.println(trees[i].toString());
        }
        System.out.println("index "+getIndex(2,trees,1));
        System.out.println("max "+getMax(1,3,trees,1));
        System.out.println("sum "+getSum(1,4,trees,1));
    }
}

