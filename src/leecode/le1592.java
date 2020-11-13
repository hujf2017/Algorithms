package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1592
 * @date 2020/11/13 0013上午 9:31
 * @description: TODO
 */
public class le1592 {
    public String reorderSpaces(String text) {
        if(text==null){
            return text;
        }
        StringBuffer buf = new StringBuffer();
        char[] ch = text.toCharArray();
       //得到字符串数组
        text = text.replaceAll(" \\s+"," ");
        String s[] = text.trim().split(" ");
        buf.append(s[0]);
        int count =0;
        for(int i=0;i<ch.length;i++){
           if(ch[i]==' '){
               //计算所有空格
               count++;
           }
       }
        //需要分配的空格數
        int len = s.length-1;
        if(len==0){
            return buf.append(calcSpace(count)).toString();
        }
        //平均每個空格數 和最後的空格
        int num = count/len;
        int lastnum = count%len;
        StringBuffer numspace = calcSpace(num);
        StringBuffer lastnumspace = calcSpace(lastnum);
        for(int i=1;i<s.length;i++){
            buf.append(numspace).append(s[i]);

        }
        buf.append(lastnumspace);
       return buf.toString();
    }

    private StringBuffer calcSpace(int num) {
        StringBuffer sbf = new StringBuffer();
        while(num>0){
            sbf.append(" ");
            num--;
        }
        return sbf;
    }
    @Test
    public void t(){
        reorderSpaces("  this   is  a sentence ");
    }
}
