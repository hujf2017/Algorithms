package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5537
 * @date 2020/10/11 0011上午 10:52
 * @description: 分割两个字符串得到回文串
 */
public class le5537 {
    public boolean checkPalindromeFormation(String a, String b) {
        StringBuffer a1 = new StringBuffer(a);
        StringBuffer b1 = new StringBuffer(b);
        if(a.equals(a1.reverse().toString())||b.equals(b1.reverse().toString())){
            return true;
        }
        int i;
        for( i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(b.length()-i-1)){
                break;
            }
        }
        String am = a.substring(0,i)+""+b.substring(i,b.length());
        StringBuffer am2 = new StringBuffer(am);
        if(am.equals(am2.reverse().toString())){
            return true;
        }
        String x1 = a.substring(0,b.length()-i)+""+b.substring(b.length()-i,b.length());
        StringBuffer x2 = new StringBuffer(x1);
        if(x1.equals(x2.reverse().toString())){
            return true;
        }

        for( i=0;i<b.length();i++){
            if(b.charAt(i)!=a.charAt(a.length()-i-1)){
                break;
            }
        }
        String bm = b.substring(0,i)+""+a.substring(i,b.length());
        StringBuffer bm2 = new StringBuffer(bm);
        if(bm.equals(bm2.reverse().toString())){
            return true;
        }

        String y1 = b.substring(0,a.length()-i)+""+a.substring(a.length()-i,a.length());
        StringBuffer y2 = new StringBuffer(y1);
        if(y1.equals(y2.reverse().toString())){
            return true;
        }

        return false;
    }

    @Test
    public void t(){
        String s2 = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd";
        String s1 = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
        System.out.println(checkPalindromeFormation(s2,s1));
    }
}
