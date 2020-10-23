package leecode;

/**
 * @author Hujf
 * @title: le404
 * @date 2020/9/19 0019上午 10:07
 * @description: TODO
 */
public class le404 {


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sumOfLeftLeaves(root));
    }

    static int sum = 0;
    public  static int sumOfLeftLeaves(TreeNode root) {

       if(root==null||(root.left==null&&root.right==null)){
           return 0;
       }
        calc(root);
        return sum;
    }

    public  static int calc(TreeNode root) {
        if(root.left!=null){
            int a= calc(root.left);
            sum+=a;
        }
        if(root.right!=null){
            calc(root.right);
        }
        if(root.left==null&&root.right==null){
            return root.val;
        }
        return 0;
    }

}
