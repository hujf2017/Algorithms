package leecode;

/**
 * @author Hujf
 * @title: le1035
 * @date 2021-05-21 15:39
 * @description: TODO
 * 1 2 3  1 2 3 4
 * 2 3 1  4 2 1 2
 */
public class le1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 =nums1.length;
        int len2 =nums2.length;
        int [][] dp = new int[len1+1][len2+1];
        for(int i=1;i<len1+1;i++){
            int num = nums1[i-1];
            for(int j=1;j<len2+1;j++){
                int num2 =nums2[j-1];
                if(num==num2){
                    dp[i][j]= dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Long a =1L;
        if(a!=null){
            System.out.println(123);
        }
        String s = "as";
        String s1 = "asd";
        String s2 = s+"d";
        System.out.println(s2==s1);
    }
}
