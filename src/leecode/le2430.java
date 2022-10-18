package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/12 11:53
 * @Description 删除前面的相同的字符
 * 删除全部
 * <p>
 * 判断前面的几个字符 是否和后面的相等
 */
public class le2430 {
    public int deleteString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        //先求前缀长度
        int[][] dp = new int[len+1][len+1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if(chars[i]==chars[j]){
                    dp[i][j] = dp[i+1][j+1]+1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        int []k = new int[len];
        for(int i=len - 1; i >= 0; i--){
            k[i] =1;
            for(int j=1;i+2*j<=len;j++){
                if(dp[i][i+j]>=j){
                    k[i] = Math.max(k[i],k[i+j]+1);
                }
            }
        }
        return k[0];
    }




    public  void test(String s ){
        int [][] num = new int[s.length()+1][s.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=s.length()-1;j>=0;j--){
                if(s.charAt(i)==s.charAt(j)){
                    num[i][j] = num[i+1][j+1]+1;
                }
            }
        }
        System.out.println(num);
    }

    @Test
    public void t(){
        deleteString("aaabaab");
    }
}
