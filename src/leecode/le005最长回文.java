package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le005最长回文
 * @date 2020/10/27 0027下午 3:57
 * @description: TODO
 */
public class le005最长回文 {
    public static String xs ;
    public static int  max=0;
    public static boolean  shodback=false;
    public static int startx;
    public static int endx;
    public static boolean  isbig=false;
    public String longestPalindrome2(String s) {
        xs= s;
        for(int i=0;i<s.length();i++){
            shodback = false;
            isbig= false;
           calca(i,s.length()-1,0);
        }
        return s.substring(startx, endx);
    }

    private void calca(int start, int end,int len) {
        if(shodback){
            return ;
        }
        if(isbig ){
            return ;
        }
        if(xs.charAt(start)==xs.charAt(end)){
            if(start==end){
                if(max<len+1){
                    max = len+1;
                    isbig  =true;
                }
            }else if(start+1== end){
                if(max<len+2){
                    max = len+2;
                    isbig  =true;
                }
            }else{
                calca(start+1,end-1,len+2);
            }
        }else{
            calca(start,end-1,0);
        }
    }

    @Test
    public void t(){
        longestPalindrome("babad");
    }

    private void longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for(int i=0;i<n;i++){
            for (int j = 0; i + j < n; j++) {
                int l = i + j;
                if(l==0){
                     dp[j][i] = true;
                }else if(l==1){
                    dp[j][l] = (s.charAt(j) == s.charAt(j));
                }else{
                    dp[j][l] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[j][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }

            }
        }
    }


}
