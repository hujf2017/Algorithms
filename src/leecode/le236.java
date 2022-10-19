package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/19 9:19
 * @Description 公共先祖
 */
public class le236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);

        if((lson&&rson)||((node.val == p.val || node.val == q.val) && (lson || rson))){
            ans = node;
        }
        return lson||rson||node==p||node==q;
    }

    @Test
    public void t() {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node3.right = node5;

        lowestCommonAncestor(node, node2, node3);
    }
}
