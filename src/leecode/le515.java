package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/10/13 11:19
 * @Description TODO
 */
public class le515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if(root==null){
            return list;
        }

        Deque <TreeNode>deque = new LinkedList();
        deque.add(root);
        deque.add(null);
        int max = root.val;
        while(deque.size()>0){
            TreeNode poll = deque.poll();

            if(poll==null){
                if(deque.size()==0){
                    break;
                }
                list.add(max);
                TreeNode peek = deque.peek();
                max = peek.val;
                deque.add(null);
                continue;
            }
            max = Math.max(poll.val,max);
            if(poll.left!=null) {
                deque.add(poll.left);
            }

            if(poll.right!=null) {
                deque.add(poll.right);
            }
        }
        list.add(max);
        return list;
    }

    @Test
    public void t(){

    }
}
