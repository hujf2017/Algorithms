package leecode;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author hujf
 * @Date 2022/6/22 9:18
 * @Description TODO
 */
public class le513 {

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList();
        que.add(root);
        que.add(null);
        List<TreeNode> a = new ArrayList<>();
        while (que.size() > 0) {
            TreeNode poll = que.poll();
            if (poll == null) {
                if (que.size() == 0) {
                    break;
                }
                a.clear();
                que.add(null);
                continue;
            }
            a.add(poll);
            if (poll.left != null) {
                que.add(poll.left);
            }
            if (poll.right != null) {
                que.add(poll.right);
            }
        }
        return a.get(0).val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    @Test
    public void t() {
        TreeNode treeNode = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        treeNode.left = left;
        treeNode.right = right;
        findBottomLeftValue(treeNode);
    }
}
