package 面试.阿里;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 大数和
 * @date 2021/4/1215:11
 * @description: TODO
 */
public class 大数和 {

    public String solve (String s, String t) {
        StringBuffer buf = new StringBuffer(s);
        StringBuffer buf2 = new StringBuffer(t);
        char[] chars = buf.reverse().toString().toCharArray();
        char[] chars2 = buf2.reverse().toString().toCharArray();
        StringBuffer buffer = new StringBuffer();
        int len=0;
        int  jinwei=0;
        while(len<chars.length&&len<chars2.length){
            int num1 = chars[len]-'0';
            int num2 = chars2[len]-'0';
            int sum = (num1+num2+jinwei)%10;
            jinwei = (num1+num2+jinwei)/10;
            buffer.append(sum);
            len++;
        }

        if(len<chars.length){
            for(;len<chars.length;len++){
                int sum = (chars[len]-'0' +jinwei)%10;
                jinwei = (chars[len]-'0' +jinwei)/10;
                buffer.append(sum);
            }
        }else{
            for(;len<chars2.length;len++){
                int sum = (chars2[len]-'0' +jinwei)%10;
                jinwei = (chars2[len]-'0' +jinwei)/10;
                buffer.append(sum);
            }
        }
        if(jinwei!=0){
            buffer.append(jinwei);
        }

        return buffer.reverse().toString();
    }
    @Test
    public void t(){
        solve("733064366","459309139");
    }
}
