package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le98
 * @date 2020/11/9 0009上午 11:23
 * @description: TODO
 */
public class le98 {
    boolean a= true;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return a;
        }
        if(root.left!=null){
            dfs(root.left,Integer.MIN_VALUE,root.val,0);
        }
        if(root.right!=null) {
            dfs(root.right, root.val,Integer.MAX_VALUE, 1);
        }
        return a;
    }
    boolean ismax = false;
    boolean ismin = false;
    private void dfs(TreeNode node, int start,int end,int type) {
        if (type == 0&&end==node.val) {
            a = false;
        }
        if (type == 1&&start ==node.val) {
            a = false;
        }
        if(node.val>=end||node.val<=start) {
                a = false;
        }
        if(node.left!=null) {
            dfs(node.left,Math.min(start,node.val),end , 0);
        }
        if(node.right!=null) {
            dfs(node.right,node.val,Math.max(end,node.val) , 0);
        }
    }
    @Test
    public void t(){
//        TreeNode node = new TreeNode(5);
//         node.left = new TreeNode(1);
//         node.right = new TreeNode(7);
//         node.right.left = new TreeNode(3);
//         node.right.right = new TreeNode(8);
        TreeNode node = new TreeNode(2147483647);
         node.right = new TreeNode(2147483647);
//         node.right.left = new TreeNode(10);
//        node.right.left.right = new TreeNode(15);
//        node.right.left.right.right = new TreeNode(45);
        isValidBST (node);

    }
}
