package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Hujf
 * @title: le113dfs
 * @date 2020/9/26 0026上午 9:08
 * @description: TODO
 */
public class le113dfs {

    @Test
    public void test() {
        TreeNode a = new TreeNode(-2);
       // a.left = new TreeNode(4);
        a.right = new TreeNode(-3);
//        a.left.left = new TreeNode(11);
//        a.left.left.left = new TreeNode(7);
//        a.left.left.right = new TreeNode(2);
//        a.right.left = new TreeNode(13);
//        a.right.right = new TreeNode(4);
//        a.right.right.left = new TreeNode(5);
//        a.right.right.right = new TreeNode(1);
        pathSum(a,-5);
    }

    List<List<Integer>>all = new ArrayList();
    int target ;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return all;
        }
        target = sum;
        List<Integer> a = new ArrayList();
        a.add(root.val);
        dfs(root,root.val,a);
        return all;
    }

    private void dfs(TreeNode root, int sum,List a) {
        if(sum == target&&root.left==null&&root.right==null){
            List k = new ArrayList(a);
            all.add(k);
            return ;
        }
        if(root.left!=null) {
            a.add(root.left.val);
            dfs(root.left,sum+root.left.val,a);
            a.remove(a.size()-1);
        }

        if(root.right!=null) {
            a.add(root.right.val);
            dfs(root.right,sum+root.right.val,a);
            a.remove(a.size()-1);
        }

    }
}
