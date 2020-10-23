package leecode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hujf
 * @title: le144
 * @date 2020/9/14 0014上午 11:56
 * @description: TODO
 */
public class le144 {
    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        preorderTraversal(root);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        Queue<TreeNode> a = new LinkedList();
        List a2 = new ArrayList();
        if(root==null){
            return a2;
        }
        a.add(root);
        a2.add(root.val);
        a2=  dfs(root,a,a2);
        return a2;
    }

    private static List dfs(TreeNode root,Queue a ,List a2) {
        if(root.left!=null){
            a.add(root.left);
            a2.add(root.left.val);
            a2 =dfs(root.left,a,a2);
        }
        if(root.right!=null){
            a.add(root.right);
            a2.add(root.right.val);
            a2 =dfs(root.right,a,a2);
        }
        return a2;
    }
}
