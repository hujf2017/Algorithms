package 面试.阿里;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 冰田联通分量
 * @date 2021/4/1214:11
 * @description: TODO
 */
public class 冰田联通分量 {

    int [][] a = new int[][]{{0,0,0,0,0,0},{0,0,1,0,0,1},{0,0,1,1,0,0},{0,0,0,1,0,1}};
    boolean [][]booleans = new boolean[a.length][a[0].length];
    public int  getline(){
        //递归思想
        int tmp =0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==1&&!booleans[i][j]) {
                   dfs(a, i, j);
                   tmp++;
                }
            }
        }
        return tmp;
    }

    private void dfs(int[][] a, int i, int j) {
        booleans[i][j]=true;
        //查找四周冰田。
        //上
        int k=i;
        int b=j;
        if(i>0){
           k=i-1;
           if(a[k][b]==1&&!booleans[k][b]){
               dfs(a,k,b);
           }
        }

        if(i<a.length-1){
            k=i+1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        if(j>0){
            b=j-1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        if(j<a[0].length-1){
            b=i+1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        //左上
        if(i>0&&j>0){
            k=i-1;
            b=j-1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        //左下
        if(i<a.length-1&&j>0){
            k=i+1;
            b=j-1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        //右上
        if(i>0&&j<a[0].length-1){
            k=i-1;
            b=j+1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }

        //右下
        if(i<a.length-1&&j<a[0].length-1){
            k=i+1;
            b=j+1;
            if(a[k][b]==1&&!booleans[k][b]){
                dfs(a,k,b);
            }
        }
    }

    @Test
    public void t(){
        getline();
    }
}
