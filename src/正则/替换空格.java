package 正则;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 替换空格
 * @date 2020/11/13 0013上午 9:36
 * @description: TODO
 */
public class 替换空格 {

    @Test
    public void t(){
        String s =  "  this   is  a sentence ";
        s= s.replaceAll(" \\s+"," ");
        System.out.println(s.trim());
        String sx[] = s.trim().split(" ");
        System.out.println(sx.length);
    }
}
