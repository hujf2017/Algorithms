package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/29 9:32
 * @Description TODO
 */
public class le1758 {
    public int minOperations(String s) {
        int []dp = new int[s.length()];
        int last = s.charAt(0) -'0';
        dp[0] =0;
        int max = 0;
        //判断是否需要改变  第一个不改变   第一个改变
        for(int i=1;i<s.length();i++){
            int num = s.charAt(i) -'0';
            //当前这个和上一个相同  且上一个没有变化
            if(num==last){
                if(dp[i-1]==0){
                    dp[i] =1;
                    max++;
                }else {
                    dp[i] =0;
                }
            }else {
                if(dp[i-1]==0){
                    dp[i] =0;
                }else {
                    dp[i] =1;
                    max++;
                }
            }
            last = num;
        }
        return Math.min(max,s.length()-max);
    }


    @Test
    public void  t(){
        minOperations("1010100111001010");
    }
}
