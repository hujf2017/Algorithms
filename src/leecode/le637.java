package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hujf
 * @title: le637
 * @date 2020/9/12 0012下午 2:13
 * @description: TODO
 */
public class le637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();  // 结果数组
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int level  = queue.size();
            for(int i =queue.size();i>=1;i--){
                TreeNode treeNode = queue.poll();
                sum+=treeNode.val;
                if(treeNode.left!=null ){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            ans.add(sum/level);
        }
        return ans;
    }
}
