package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le738单调递增
 * @date 2020/12/15 0015下午 1:42
 * @description: 找比这个数小的递增序列
 */
public class le738单调递增 {
    public int monotoneIncreasingDigits(int N){
        String s = String.valueOf(N);
        char [] ch = s.toCharArray();
        boolean ishave = false;
        int last = ch[0];
        int len =1;
        int i=1;
        for(;i<ch.length;i++){
            if(last>ch[i]){
                break;
            }else if(last ==ch[i]){
                len++;
            }else{
                len =1;
                last = ch[i];
                continue;
            }
        }
        StringBuffer buf = new StringBuffer();
        int start = i-len;
        for(int j=0;j<ch.length;j++){
            if(j==start){
                if(start!=ch.length-1){
                    buf.append(ch[j]-'0'-1);
                }else{
                    buf.append(ch[j]-'0');
                }
            }else if(j>start){
                buf.append(9);
            }else{
                buf.append(ch[j]-'0');
            }
        }
        return Integer.valueOf(buf.toString());
    }

    @Test
    public void t(){
        System.out.println(monotoneIncreasingDigits(1234));
    }
}
