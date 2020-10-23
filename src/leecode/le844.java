package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le844
 * @date 2020/10/19 0019下午 6:23
 * @description: TODO
 */
public class le844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer buf1 =new StringBuffer();
        StringBuffer buf2 =new StringBuffer();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(buf1.length()>0){
                    buf1.deleteCharAt(buf1.length() - 1);
                }
            }else{
                buf1.append(S.charAt(i));
            }
        }

        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'){
                if(buf2.length()>0) {
                    buf2.deleteCharAt(buf2.length() - 1);
                }
            }else{
                buf2.append(T.charAt(i));
            }
        }
        System.out.println(buf1.toString().equals(buf2.toString()));
        return buf1.toString().equals(buf2.toString());
    }

    @Test
    public void t(){
        String s1 = "#ab#c";
        String s2 = "ad#c";

        backspaceCompare(s1,s2);
    }
}
