package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le91
 * @date 2021-04-21 14:02
 * @description: TODO
 */
public class le91 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'||s.length()==0){
            return 0;
        }

        int []f =new int [s.length()+1];

        f[0]=1;

        for(int i=1;i<=s.length();i++){
            f[i]=0;
            //前一个不为0
            if(s.charAt(i-1)-'0'>=1){
                f[i]+=f[i-1];
            }
            if(i>=2&&(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')<=26&&(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')>=1&&s.charAt(i-2)!='0'){
                f[i]+=f[i-2];
            }
        }
        return f[s.length()];
    }

    @Test
    public void test(){
        numDecodings("2101");
    }
}
