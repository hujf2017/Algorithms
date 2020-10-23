package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le106
 * @date 2020/9/25 0025上午 10:00
 * @description: TODO
 */
public class le106中序后续求树 {
    int post_idx;
    int[] postorder;
    int[] inorder;

    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_idx = postorder.length - 1;
        int idx = 0;
        //获取一个中序的值和序列
        for(int a  :inorder){
            idx_map.put(a, idx++);
        }
                //中序的前后
       return  helper(0,inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left >right){
            return null;
        }
        int num = postorder[post_idx];
        TreeNode root = new TreeNode(num);
        //拿到当前数据在中序位置，以这个位置区分左右
        int index =idx_map.get(num);

        // 后续下标往前一个
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, right);
        // 构造左子树
        root.left = helper(left, index - 1);
        return root;

    }
}
