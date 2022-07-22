package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/7/21 15:38
 * @Description TODO
 */
public class le814 {

    public TreeNode pruneTree(TreeNode root) {

        dfs(root.left, root, 0);
        dfs(root.right, root, 1);
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }

    private void dfs(TreeNode x, TreeNode toor, int num) {
        if (x == null) {
            return;
        }
        dfs(x.left, x, 0);
        dfs(x.right, x, 1);
        if (x.left == null && x.right == null && x.val == 0) {
            if (num == 0) {
                toor.left = null;
            } else {
                toor.right = null;
            }
        }
    }

    @Test
    public void t() {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;

        pruneTree(node1);
    }
}
