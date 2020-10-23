package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le917
 * @date 2020/10/10 0010上午 10:40
 * @description: TODO
 */
public class le917 {
    public String reverseOnlyLetters(String S) {
        StringBuffer s1= new StringBuffer();
        int count = 0;
        for(int i=S.length()-1;i>=0&&count<S.length();i--){
            char a = S.charAt(i);
            char b = S.charAt(count);
            if(!(b>=65&&b<=90)&&!(b>=97&&b<=122)){
                s1.append(b);
                count++;
                i++;
                continue;
            }
            if((a>=65&&a<=90)||(a>=97&&a<=122)){
                s1.append(a);
                count++;
            }
        }
       while(count<S.length()){
           s1.append(S.charAt(count));
           count++;
       }
        return s1.toString();

    }

    @Test
    public void test(){
        char a = '!';
        char b = 'z';
        char c  ='A';
        char d  ='Z';
        System.out.println((int)a);
        System.out.println((int)b);
        System.out.println((int)c);
        System.out.println((int)d);

        reverseOnlyLetters("!");
    }
}
