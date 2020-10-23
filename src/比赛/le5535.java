package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5535
 * @date 2020/10/11 0011上午 10:35
 * @description: TODO
 */
public class le5535 {
    public int maxDepth(String s) {
        int count =0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            if(s.charAt(i)==')'){
                if(count>max){
                    max = count;
                }
                count --;
            }
        }
        return max;
    }

    @Test
    public void test(){
        String s = "(1)+((2))+(((3)))";
        maxDepth(s);
    }
}
