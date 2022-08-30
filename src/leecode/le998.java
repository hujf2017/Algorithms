package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/30 9:34
 * @Description TODO
 */
public class le998 {
    boolean isOKJ= false;
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root.val<val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (root.left != null) {
            dfs(root, root.left, val, 0);
            if(isOKJ){
                return root;
            }
        }
        if (root.right != null) {
            dfs(root, root.right, val, 1);
        }
        return root;
    }

    private void dfs(TreeNode last, TreeNode root, int val, int left) {
        if(isOKJ){
            return;
        }
        if (root.val < val) {
            isOKJ = true;
            TreeNode node = new TreeNode(val);
            node.left = root;
            if (left == 0) {
                last.left = node;
            } else {
                last.right = node;
            }
        } else {
            if (root.left != null) {
                dfs(root, root.left, val, 0);
            }
            if (root.right != null) {
                dfs(root, root.right, val, 1);
            }
        }
    }


    @Test
    public void t(){
        TreeNode last = new TreeNode(5);
        TreeNode last1 = new TreeNode(4);
        TreeNode last2 = new TreeNode(3);
        TreeNode last3 = new TreeNode(2);
        TreeNode last4 = new TreeNode(1);

        last.left = last3;
        last.right = last1;
        last3.right= last4;

        insertIntoMaxTree(last,3);
    }
}
