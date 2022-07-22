package 线段树;

/**
 * @Author hujf
 * @Date 2022/7/22 11:02
 * @Description TODO
 */
public class ThreadTree {

    Tree[] trees;
    int[] data;

    private ThreadTree(int[] data) {
        //1.开线段树的数组空间
        this.trees = new Tree[data.length * 4];
        this.data = data;
        //2.初始化线段树
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
        }
    }

    private void buildTree(int[] data, Tree[] trees, int left, int right, int nodeNum) {
        trees[nodeNum].left = left;
        trees[nodeNum].right = right;
        if (left == right) {
            trees[nodeNum].sum = data[left];
            return;
        } else {

            int mid = (left + right) >> 1;
            //二叉搜索树  *2 位置 找递归节点
            buildTree(data, trees, left, mid, nodeNum * 2);
            buildTree(data, trees, mid + 1, right, nodeNum * 2 + 1);
            trees[nodeNum].sum = trees[nodeNum * 2].sum + trees[nodeNum * 2 + 1].sum;
        }
    }

    //查找指定范围内的和
    public int getSum(int left, int right, int nodeNum, Tree[] trees) {
        int mid = (trees[nodeNum].left + trees[nodeNum].right) >> 1;

        if (trees[nodeNum].left == trees[nodeNum].right || (trees[nodeNum].left == left && trees[nodeNum].right == right)) {
            return trees[nodeNum].sum;
        }

        if (mid >= right) {
            return getSum(left, right, 2 * nodeNum, trees);
        } else if (mid < left) {
            return getSum(left, right, 2 * nodeNum + 1, trees);
        } else {
            int temp = getSum(left, right, 2 * nodeNum, trees);
            int temp1 = getSum(left, right, 2 * nodeNum + 1, trees);
            return temp + temp1;
        }
    }

    //更新线段树
    public void update(int value, int index, int nodeNum) {
        int treeIndex = getTreeIndex(index, nodeNum);
        //直接从这个节点回溯
        trees[treeIndex].sum = value;

        int i = treeIndex >> 1;
        while (i >= nodeNum) {
            trees[i].sum = trees[i * 2].sum + trees[i * 2 + 1].sum;
            i = i >> 1;
        }

    }

    //
    public int getTreeIndex(int index, int nodeNum) {
        if (trees[nodeNum].left == index && trees[nodeNum].right == index) {//左右边界值相等
            return nodeNum;
        }
        int mid = (trees[nodeNum].left + trees[nodeNum].right) >> 1;
        if (mid >= index) {
            return getTreeIndex(index, nodeNum * 2);
        } else {
            return getTreeIndex(index, nodeNum * 2 + 1);
        }
    }

    public static void main(String args[]) {
        int[] ints = {0, 1, 2, 3, 4, 5};
        ThreadTree threadTree = new ThreadTree(ints);
        threadTree.buildTree(threadTree.data, threadTree.trees, 1, threadTree.data.length - 1, 1);
        int sum = threadTree.getSum(2, 4, 1, threadTree.trees);
        System.out.println(sum);
        threadTree.update(3, 2, 1);
        System.out.println(threadTree.getSum(2, 4, 1, threadTree.trees));
    }

}

class Tree {
    int left;
    int right;
    int max;
    int sum;

    public Tree() {

    }
}