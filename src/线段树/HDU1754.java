package 线段树;

import java.util.Scanner;

/**
 * @Author hujf
 * @Date 2022/7/22 16:10
 * @Description TODO
 */
public class HDU1754 {

    public void main() {
        Scanner scanner = new Scanner(System.in);
        //学生id 1-n
        int n = scanner.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = scanner.nextInt();
        }
        //开辟4n 树
        MyTree myTrees[] = new MyTree[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            myTrees[i] = new MyTree();
        }
        buildTree(myTrees, score, 1, n + 1, 1);
        //有m 行
        int m = scanner.nextInt();

        while (m > 0) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");

            switch (s1[0]) {
                case "Q":
                    System.out.println(findMax(Integer.valueOf(s1[1]), Integer.valueOf(s1[2]), myTrees, score, 1));
                    break;
                default:
                    Update(Integer.valueOf(s1[1]), Integer.valueOf(s1[2]), myTrees, score, 1);
                    break;
            }
            m--;
        }

    }

    private void Update(Integer id, Integer value, MyTree[] myTrees, int[] score, int nodeStart) {
        int local = findIndex(id, myTrees, 1);
        myTrees[local].max = value;
        local = local >> 1;
        while (local >= nodeStart) {
            int left = myTrees[local].left;
            int right = myTrees[local].right;
            myTrees[local].max = Math.max(myTrees[left].max, myTrees[right].max);
        }
    }

    private int findIndex(Integer id, MyTree[] myTrees, int nodeStart) {
        if (myTrees[nodeStart].left == id && myTrees[nodeStart].right == id) {
            return nodeStart;
        }

        int mid = (myTrees[nodeStart].left + myTrees[nodeStart].right) >> 1;
        if (mid >= id) {
            return findIndex(id, myTrees, nodeStart * 2);
        } else {
            return findIndex(id, myTrees, nodeStart * 2 + 1);
        }
    }

    private int findMax(int left, int right, MyTree[] myTrees, int[] score, int nodeStart) {
        if (left == right || (myTrees[nodeStart].left == left && myTrees[nodeStart].right == right)) {
            return myTrees[nodeStart].max;
        }
        int mid = (left + right) >> 1;
        if (mid >= right) {
            //左子树
            return findMax(left, right, myTrees, score, nodeStart * 2);
        } else if (mid < left) {
            return findMax(left, right, myTrees, score, nodeStart * 2 + 1);
        } else {
            int num1 = findMax(left, mid, myTrees, score, nodeStart * 2);
            int num2 = findMax(mid, right, myTrees, score, nodeStart * 2);
            return num1 + num2;
        }

    }

    private void buildTree(MyTree[] myTrees, int[] score, int left, int right, int nodeStart) {
        myTrees[nodeStart].left = left;
        myTrees[nodeStart].right = right;
        if (left == right) {
            myTrees[nodeStart].max = score[left];
            return;
        }

        int mid = (left + right) >> 1;
        buildTree(myTrees, score, left, mid, nodeStart * 2);
        buildTree(myTrees, score, mid + 1, right, nodeStart * 2 + 1);
        myTrees[nodeStart].max = Math.max(myTrees[left].max, myTrees[right].max);
    }
}

class MyTree {
    int left;
    int right;
    int max;
}
