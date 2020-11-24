package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le848
 * @date 2020/11/24 0024下午 1:30
 * @description: TODO
 */
public class le848 {

    public String shiftingLetters(String S, int[] shifts) {
        long []dp = new long[S.length()+1];
        dp[S.length()]= 0;
        for(int i=shifts.length-1;i>=0;i--){
            dp[i]= dp[i+1]+shifts[i];
        }

        char[] ch =S.toCharArray();
        for(int i=0;i<ch.length;i++){
           //这是移动之后的位置
            System.out.println((int)'a');
            long num = ch[i]+dp[i]-122;
            if(num<0){
                ch[i] = (char)(ch[i]+dp[i]);
            }else if(num==0){
                ch[i] ='z';
            }else{
                long num2 = num%26;
                if(num2==0){
                    ch[i] ='z';
                }else {
                    ch[i] = (char) (num2 + 96);
                }
            }
        }
        return String.copyValueOf(ch);
    }
    @Test
    public void t(){
        String s=shiftingLetters("z",new int[]{52});
        System.out.println(s);
    }
}
