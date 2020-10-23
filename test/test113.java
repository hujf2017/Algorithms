import common.TreeNode;
import leecode.le113dfs;
import org.junit.Test;

import java.util.List;


/**
 * @author Hujf
 * @title: test113
 * @date 2020/9/26 0026上午 9:20
 * @description: TODO
 */
public class test113 {
    @Test
    public void test() {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(4);
        a.right = new TreeNode(8);
        a.left.left = new TreeNode(11);
        a.left.left.left = new TreeNode(7);
        a.left.left.right = new TreeNode(2);
        a.right.left = new TreeNode(13);
        a.right.right = new TreeNode(4);
        a.right.right.left = new TreeNode(5);
        a.right.right.right = new TreeNode(1);
        le113dfs asda = new le113dfs();
    }

}
