package leecode;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author hujf
 * @Date 2022/3/21 10:07
 * @Description 二叉查找树
 */
public class le653 {
    boolean a =false;
    public boolean findTarget(TreeNode root, int k) {
        //遍历
        HashSet<Integer> set = new HashSet();

        dfs(root,set,k);

        return a;
    }

    private void dfs(TreeNode root, HashSet set, int k) {
        if(root==null){
            return ;
        }
        if(set.contains(k-root.val)){
            a=true;
        }
        set.add(root.val);
        dfs(root.left,set,k);
        dfs(root.right,set,k);
    }

    @Test
    public void t(){

    }
}
