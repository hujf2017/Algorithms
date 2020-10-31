package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le463
 * @date 2020/10/30 0030上午 9:24
 * @description: TODO
 */
public class le463 {
    static int len,leny ;
    int a[][];
    public int islandPerimeter(int[][] grid) {
        a = grid;
        int sum = 0;
        len=grid.length;
        leny = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    sum += 4-calcNum(i,j);
                }
            }
        }
        return sum;
    }

    private int calcNum(int i,int j) {
        int num =0;
        if(i+1<len&&a[i+1][j]==1){
            num+=1;
        }
        if(i-1>=0&&a[i-1][j]==1){
            num+=1;
        }
        if(j+1<leny&&a[i][j+1]==1){
            num+=1;
        }
        if(j-1>=0&&a[i][j-1]==1){
            num+=1;
        }
        return num;
    }

    @Test
    public void t(){
        int a[][] = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int b[][] = {{1,1}};
        islandPerimeter(b);
    }
}
