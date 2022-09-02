package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/9/2 11:06
 * @Description TODO
 */
public class le687 {
    int max = 0;


    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root, 1001), max);
    }

    private int dfs(TreeNode root, int last) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left, root.val);
            if (root.left.val == root.val) {
                left++;
            }else{
                left= 0;
            }
        }

        if (root.right != null) {
            right = dfs(root.right, root.val);
            if (root.right.val == root.val) {
                right++;
            }else{
                right = 0;
            }
        }
        max = Math.max(left + right, max);
        return Math.max(left, right);

    }

    @Test
    public void t() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4x= new TreeNode(4);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4x;
        treeNode1.left=treeNode;


        System.out.println(longestUnivaluePath(treeNode1));
//
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(5);
//        TreeNode treeNode7 = new TreeNode(3);
//
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//
//        TreeNode treeNode8 = new TreeNode(4);
//        TreeNode treeNode9 = new TreeNode(4);
//        treeNode4.left = treeNode8;
//        treeNode4.right = treeNode9;
//
//
//        TreeNode treeNode10 = new TreeNode(4);
//        TreeNode treeNode11 = new TreeNode(4);
//        treeNode10.left = treeNode11;
//        treeNode8.left = treeNode10;
//
//        TreeNode treeNode12 = new TreeNode(4);
//        TreeNode treeNode13 = new TreeNode(4);
//        treeNode12.left = treeNode13;
//        treeNode9.left = treeNode12;
//
//        System.out.println(longestUnivaluePath(treeNode));
    }
}
