package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le94
 * @date 2020/9/14 0014下午 12:23
 * @description: TODO
 */
public class le94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List a = new ArrayList();
        if(root==null){
            return a;
        }
        a.add(root.val);
        a =dfs(root,a) ;
        return a;
    }

    private List dfs(TreeNode root, List a) {

        if(root.left!=null){
            a =dfs(root.left,a);
        }
        a.add(root.val);
        if(root.right!=null){
            a =dfs(root.right,a);
        }
        return a;

    }
}
