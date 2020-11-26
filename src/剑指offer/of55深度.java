package 剑指offer;

import common.TreeNode;

/**
 * @author Hujf
 * @title: of55深度
 * @date 2020/11/25 0025上午 10:29
 * @description: TODO
 */
public class of55深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return  Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
