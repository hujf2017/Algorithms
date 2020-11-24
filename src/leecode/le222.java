package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le222
 * @date 2020/11/24 0024下午 1:16
 * @description: 计算
 */
public class le222 {
    //笨比解法  层序遍历
    public int countNodes(TreeNode root) {
        Deque<TreeNode> que = new LinkedList();
        que.add(root);
        int count=0;
        while(!que.isEmpty()){
            TreeNode node =que.poll();
            if(node.left!=null){
                que.add(node.left);
            }
            if(node.right!=null){
                que.add(node.right);
            }

            count ++;
        }
        return count;
    }


    /**
     * 牛逼解法
     * 1.深度遍历
     * 2.每次返回左右子树个数和
     */

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left +right+1;
    }



    /**
     * 速度最快解法
     * 1.深度遍历 找到层
     * 2.
     */
}
