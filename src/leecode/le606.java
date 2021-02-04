package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le606
 * @date 2021/2/4 0004上午 9:09
 * @description: TODO
 */
public class le606 {
    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t != null) {
            sb.append(t.val);

            if (t.left != null) {
                sb.append("(");
                tree2str(t.left);
                sb.append(")");
            }else{
                if(t.right!=null){
                    sb.append("()");
                }
            }
            if (t.right != null) {
                sb.append("(");
                tree2str(t.right);
                sb.append(")");
            }
        }
        return sb.toString();
    }

    @Test
    public void t(){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        String s =tree2str(t);

        System.out.println(s);
    }

}
