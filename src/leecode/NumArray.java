package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/8/29 16:26
 * @Description 线段树
 */
public class NumArray {

    Tree[] Tree;
    Map map = new HashMap<>();

    public NumArray(int[] nums) {
        this.Tree = new Tree[nums.length * 4];
        for (int i = 0; i < nums.length * 4; i++) {
            Tree[i] = new Tree();
        }
        buildTree(nums, 0, nums.length-1 , 1);
    }

    private void buildTree(int[] nums, int start, int end, int nodeNum) {
        Tree[nodeNum].left = start;
        Tree[nodeNum].right = end;
        if (start == end) {
            map.put(start, nodeNum);
            Tree[nodeNum].sum = nums[start];
        } else {
            int mid = (start + end) >> 1;
            buildTree(nums, start, mid, nodeNum * 2);
            buildTree(nums, mid + 1, end, nodeNum * 2 + 1);
            Tree[nodeNum].sum = Tree[nodeNum * 2].sum + Tree[nodeNum * 2 + 1].sum;
        }
    }

    public void update(int index, int val) {
        int treeIndex = (int) map.get(index);
        Tree[treeIndex].sum = val;

        int x = treeIndex >> 1;
        while (x > 0) {
            Tree[x].sum = Tree[x * 2].sum + Tree[x * 2 + 1].sum;
            x = x >> 1;
        }
    }

    public int sumRange(int left, int right) {
        return getSum(left, right, 1);
    }

    private int getSum(int left, int right, int i) {
        if ((Tree[i].left == left && Tree[i].right == right) || (Tree[i].left==Tree[i].right)) {
            return Tree[i].sum;
        }
        int mid = (Tree[i].left + Tree[i].right) >> 1;
        //全左
        if (mid >= right) {
            return getSum(left, right, 2 * i);
        } else if (mid < left) {
            return getSum(left, right, 2 * i + 1);
        } else {
            int num1 = getSum(left, mid, i * 2);
            int num2 = getSum(mid + 1, right, i * 2 + 1);
            return num1 + num2;
        }
    }


    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,3,5});
        System.out.println(numArray.sumRange(1, 2));
        numArray.update(1,4);
        System.out.println(numArray.sumRange(1, 2));
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