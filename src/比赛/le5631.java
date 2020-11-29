package 比赛;

/**
 * @author Hujf
 * @title: le5631
 * @date 2020/11/29 0029上午 10:47
 * @description: TODO
 */
public class le5631 {
    public int maximumWealth(int[][] accounts) {
        int len = accounts.length;
        int max =0;
        for(int i=0;i<len;i++){
            int sum =0;
            for(int j=0;j<accounts[0].length;j++){
                sum+=accounts[i][j];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
