package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/5 9:13
 * @Description TODO
 */
public class le623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode node = new TreeNode(val);
        if (depth == 1) {
            node.left = root;
            return node;
        }

        dfs(root, depth - 1, val);

        return root;
    }

    private void dfs(TreeNode root, int depth, int node) {
        if(root==null){
            return;
        }
        if (depth == 1) {
            TreeNode tmp = root.left;
            TreeNode tmp2 = root.right;
            TreeNode node1 = new TreeNode(node);
            TreeNode node2 = new TreeNode(node);
            root.left = node1;
            root.right = node2;
            node1.left = tmp;
            node2.right = tmp2;
            return;
        }
        dfs(root.left, depth - 1, node);
        dfs(root.right, depth - 1, node);
    }

    @Test
    public void t() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);


        node3.left = node1;
        node1.left=node2;
        node1.right= node;

        addOneRow(node3,1,3);
    }
}
