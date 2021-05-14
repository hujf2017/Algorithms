package leecode;

/**
 * @author Hujf
 * @title: le1723
 * @date 2021-05-08 17:30
 * @description: TODO
 */
public class le1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        //2进制
        int m=1<<jobs.length;
        int[][]dp=new int[k][m];

        for(int i=0;i<m;i++){
            int tmp=i,count=0;
            while(tmp>0){
                if(tmp%2==1){
                    dp[0][i]+=jobs[count];
                }
                count++;
                tmp>>=1;
            }
        }
        return 0;
    }
}
