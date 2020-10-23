package leecode;

/**
 * @author Hujf
 * @title: le617
 * @date 2020/9/23 0023上午 10:21
 * @description: TODO
 */
public class le617 {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);


        mergeTrees(root,root2);

        int a =1;
    }

    static TreeNode root = new  TreeNode(0) ;
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1==null&&t2 ==null){
            return null;
        }else if(t1 ==null){
            return t2;
        }else if(t2 ==null){
            return t1;
        }else {
            //两个节点都有

            t1.val = t2.val+t1.val;
            if(t1.left!=null&&t2.left!=null){
                mergeTrees(t1.left, t2.left);
            }else if(t1.left==null){
                t1.left = t2.left;
            }else {
               //啥也不干
            }


            if(t1.right!=null&&t2.right!=null) {
                mergeTrees(t1.right, t2.right);
            }else if(t1.right==null){
                t1.right = t2.right;
            }else {
                //啥也不干
            }

            return t1;
        }

    }
}
