package 线段树;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/28 16:48
 * @Description TODO
 */
public class TreeTh {

    public TreeTh(int[] arr) {
        //先开一个4被空间
        treeThs = new HTree[arr.length * 4];

        for (int i = 0; i < arr.length * 4; i++) {
            treeThs[i] = new HTree();
        }
        buildTree(0, arr.length - 1, 1, arr);
    }

    public void findMax(int left, int right) {


    }


    public void findSum(int left, int right, int treeIndex) {


    }


    HTree[] treeThs;

    public void buildTree(int left, int right, int treeIndex, int[] arr) {
        treeThs[treeIndex].left = left;
        treeThs[treeIndex].right = right;
        if (left == right) {
            treeThs[treeIndex].left = left;
            treeThs[treeIndex].right = left;
            treeThs[treeIndex].max = arr[left];
        } else {
            int mid = (left + right) >> 1;
            buildTree(left, mid, treeIndex * 2, arr);
            buildTree(mid + 1, right, treeIndex * 2 + 1, arr);
            treeThs[treeIndex].max = Math.max(treeThs[treeIndex * 2].max, treeThs[treeIndex * 2 + 1].max);
        }
    }


    class HTree {
        public int left;
        public int right;
        public int max;
        public int sum;
    }


    public static void main(String[] args) {
        TreeTh treeTh = new TreeTh(new int[]{1, 23, 453, 25, 43, 56, 5, 46, 645, 1});
        System.out.println(treeTh);
    }
}
