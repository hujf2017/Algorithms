package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le501
 * @date 2020/9/24 0024下午 4:55
 * @description: TODO
 */
public class le501 {

    public static void main(String args[]){
        TreeNode a = new TreeNode(1);
      a.right = new TreeNode(2);
      a.left = new TreeNode(1);
      //  System.out.println(findMode(a));
        System.out.println(findMode2(a));
    }
    static ArrayList<Integer> ax2 = new ArrayList<Integer>();
    private static int[]  findMode2(TreeNode a) {
        if(a==null){
            return new int[]{};
        }
        calc2(a);
        int x2=a.val;
        int count =0;
        int max=1;
        List sasd = new ArrayList();
        sasd.add(x2);
        for(int x :ax2){
            if(x==x2){
                count++;
                if(max<count){
                    sasd.clear();;
                    sasd.add(x2);
                }else if(max==count&&!sasd.contains(x2)){
                    sasd.add(x2);
                }
            }else{
                if(max<count){
                    sasd.clear();;
                    sasd.add(x2);

                }else if(max==count&&!sasd.contains(x2)){
                    sasd.add(x2);
                }
                x2 = x;
                count = 1;
            }
        }

        int s[] = new int[sasd.size()];
        for(int i = 0;i<sasd.size();i++){
            s[i] = (int) sasd.get(i);
        }
        return s;
    }

    private static void calc2(TreeNode a) {
        if(a.left!=null){
            calc2(a.left);
        }
        ax2.add(a.val);
        if(a.right!=null){
            calc2(a.right);
        }
    }


    static int count = 1;
    static int max;
    static int n;
    static ArrayList<Integer> ax = new ArrayList<Integer>();
    public static int[] findMode(TreeNode root) {
        if(root==null){
            return new int[]{};
        }

        ax.add(root.val);

        calc(root);
        int k[] =new int[ax.size()];
        for(int i=0;i<ax.size();i++){
            k[i] = ax.get(i);
        }
        return k;
    }

    private static int calc(TreeNode root) {


        if(root.left!=null){
            n= calc(root.left);
           if(n==root.val){
               count++;
           }else{
               if(max<count ){
                   max = count;
                   ax.clear();
                   ax.add(n);
               }else if(max==count){
                   ax.add(n);
               }else{

               }
               count = 1;
           }
        }

        if(root.right!=null){
            n= calc(root.right);
            if(n==root.val){
                count++;
            }else{

                if(max<count ){
                    max = count;
                    ax.clear();
                    ax.add(n);
                }else if(max==count){
                    ax.add(n);
                }else{

                }
                count =1;
            }
        }

        return root.val;

    }

}
