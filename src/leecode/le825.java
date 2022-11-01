package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/21 17:47
 * @Description TODO
 */
public class le825 {
    public int numFriendRequests(int[] ages) {
        int [] agess = new int[121];
        for(int i:ages){
            agess[i]+=1;
        }

        int[] pre = new int[121];
        for(int i=1;i<121;i++){
            pre[i] = pre[i - 1] + agess[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (agess[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += agess[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;

    }

    @Test
    public void t(){
        numFriendRequests(new int[]{16,16});
    }
}

