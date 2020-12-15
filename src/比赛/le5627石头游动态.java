package 比赛;

/**
 * @author Hujf
 * @title: le5627石头游动态
 * @date 2020/12/13 0013上午 10:44
 * @description: TODO
 */
public class le5627石头游动态 {

    public int stoneGameVII(int[] stones) {
        int sum =0;
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
        }
        System.out.println(sum);
        return sum;
    }
}
