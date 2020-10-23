package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le344
 * @date 2020/10/8 0008下午 5:32
 * @description: TODO
 */
public class le344 {
    char[] s ={};
    @Test
    public void reverseString() {
        int i=0;
        int j = s.length-1;
        while(i<j){
            char tmp  = s[i];
            s[i]=s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        System.out.println(s);
    }

}
