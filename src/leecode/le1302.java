package leecode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author hujf
 * @Date 2022/8/17 9:19
 * @Description TODO
 */
public class le1302 {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode zero= new TreeNode(0);
        queue.add(root);
        queue.add(zero);
        int count =0;
        while(queue.size()>0){
            TreeNode poll = queue.poll();
            if(poll.val==0){
                if(queue.size()>0){
                    count=0;
                    queue.add(zero);
                    continue;
                }else {
                   return count;
                }
            }
            count+=poll.val;
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
        }
        return count;
    }

    @Test
    public void t(){
        TreeNode root = new TreeNode(1);
        TreeNode leftr = new TreeNode(2);
        TreeNode right = null;
        root.left = leftr;
        root.right =null;
        deepestLeavesSum(root);
    }
}
