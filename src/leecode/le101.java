package leecode;

/**
 * @author Hujf
 * @title: le101
 * @date 2021/3/8 0008下午 4:03
 * @description: TODO
 */
public class le101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode left,TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }
}
