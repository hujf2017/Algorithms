package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1824
 * @date 2021/4/1215:45
 * @description: 贪心
 */
public class le1824 {

    public int minSideJumps(int[] obstacles) {
        int local =2;
        int n = obstacles.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(obstacles[i]==local){
                count++;
                local =panduan(obstacles,i-1,local);
            }
        }
        return count;
    }

    private int panduan(int[] obstacles, int x,int lastlocal) {
        for(int i=x;i<obstacles.length;i++){
            if(obstacles[i]!=lastlocal&&obstacles[i]!=0){
                return 6-obstacles[i]-lastlocal;
            }
        }
        return 1;
    }
    @Test
    public void t(){
        System.out.println(Integer.MAX_VALUE);
        minSideJumps(new int[]{0,2,1,0,3,0,2,0});
    }
}
