package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le235
 * @date 2020/9/27 0027上午 10:17
 * @description: TODO
 */
public class le235 {
    @Test
    public void test(){
        TreeNode node = new TreeNode(2);
         node.left = new TreeNode(1);
//        node.right = new TreeNode(8);
//        node.left.left= new TreeNode(0);
//        node.left.right = new TreeNode(4);
//        node.left.right.left = new TreeNode(3);
//        node.left.right.right = new TreeNode(5);
//        node.right.right = new TreeNode(9);
//        node.right.left = new TreeNode(7);
        lowestCommonAncestor(node,node,node.left );
        System.out.println(aim);
    }
    TreeNode aim1 ;
    TreeNode aim2 ;
    TreeNode aim;
    private TreeNode lowestCommonAncestor(TreeNode node, TreeNode left, TreeNode right) {
        aim1 = new TreeNode(left.val);
        aim2 = new TreeNode(right.val);;
        if(aim1.val>aim2.val){
            int num = aim1.val;
            aim1.val = aim2.val;
            aim2.val = num;
        }
        dfs2(node);
        return aim;
    }
    private void dfs2(TreeNode node) {
        if(aim!=null){
            return ;
        }
        //大于两个节点
        if(node.val>aim1.val&&node.val>aim2.val){
            dfs2(node.left);
        }
        //小于两个节点
        if(node.val<aim1.val&&node.val<aim2.val){
            dfs2(node.right);
        }
        if(node.val==aim1.val){
            aim = aim1;
        }else if(node.val==aim2.val){
            aim = aim2;
        }else if(node.val>aim1.val&&node.val<aim2.val){
            aim = node;
        }
    }

//    List<TreeNode> a = new ArrayList<TreeNode>();
//
//    TreeNode isUsed;
//    TreeNode aim;
//    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
//       //保证aim1小于阿咪2
//        aim1 = p;
//        aim2 = q;
//        if(aim1.val>aim2.val){
//            int num = aim1.val;
//            aim1.val = aim2.val;
//            aim2.val = num;
//        }
//        dfs(root);
//        return aim;
//    }
//
//    private void dfs(TreeNode root) {
//        if(aim!=null){
//            return ;
//        }
//        if(root.val==aim1.val){
//            isUsed = root;
//        }
//
//        if(root.val ==aim2.val){
//            aim = isUsed;
//            return ;
//        }
//        if(root.left!=null){
//            dfs(root.left);
//            if(isUsed!=null){
//                isUsed = root;
//            }
//        }
//        if(root.right!=null){
//            dfs(root.right);
//            if(isUsed!=null){
//                isUsed = root;
//            }
//        }
//    }
}
