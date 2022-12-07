package leecode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/11/9 14:12
 * @Description 找友视图能看到的最后一个
 * <p>
 * 层序遍历 每层的最后一个
 */
public class le199 {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        TreeNode last = null;
        while (deque.size() > 0) {
            int size =deque.size();
            for(int i=0;i<size;i++){
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
                last = poll;
            }
            list.add(last.val);

        }
        return list;
    }

    @Test
    public void t() {
        TreeNode root = new TreeNode(0);
        TreeNode treeNode = new TreeNode(1);
        root.right = treeNode;
        rightSideView(root);
    }
}
