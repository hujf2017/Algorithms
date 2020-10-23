package leecode;

/**
 * @author Hujf
 * @title: le538
 * @date 2020/9/21 0021下午 8:32
 * @description: TODO
 */
public class le538 {
    public static void main(String args[]){


    }
    int num = 0;
    public TreeNode convertBST(TreeNode root) {

        //右中左
        if(root!=null){
            convertBST(root.right);
            root.val= root.val+num;
            num = root.val;
            convertBST(root.left);
            return root;

        }
        return null;
    }
}
