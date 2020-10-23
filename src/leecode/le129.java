package leecode;

/**
 * @author Hujf
 * @title: le129
 * @date 2020/9/29 0029下午 5:07
 * @description: TODO
 */
public class le129 {
    int sum = 0;
    String s="" ;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return sum ;
        }
        dfs(root,root.val);
        return sum ;
    }

    private void dfs(TreeNode root, int s) {
        if(root.left==null&&root.right==null){
            sum+=s;
        }else{
            if(root.left!=null){
                dfs(root.left,s+root.left.val);
            }
            if(root.right!=null){
                dfs(root.right,s+root.right.val);
            }

        }

    }

}
