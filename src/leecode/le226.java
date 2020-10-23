package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hujf
 * @title: le226
 * @date 2020/9/16 0016上午 9:03
 * @description: TODO
 */
public class le226 {

    @Test
    public void invertTree() {
        TreeNode root=new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode node = new TreeNode(4);

        node = dfs(root,node);
        System.out.println(node);
    }

    private TreeNode dfs(TreeNode root,TreeNode node) {
        if(root.left!=null){
            TreeNode nodex  = new TreeNode(root.left.val);
            node.right = nodex;
        }
        if(root.right!=null){
            TreeNode nodex  = new TreeNode(root.right.val);
            node.left = nodex;
        }
        if(node.left!=null) {
             dfs(root.right, node.left);
        }
        if(node.right!=null) {
             dfs(root.left, node.right);
        }
        return node;
    }
}
