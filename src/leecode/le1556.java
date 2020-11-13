package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1556
 * @date 2020/11/13 0013上午 10:06
 * @description: TODO
 */
public class le1556 {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        for(int i = sb.length() - 3; i > 0; i -= 3){
            sb.insert(i, '.');
        }
        return sb.toString();
    }

    @Test
    public void t(){
        thousandSeparator(1234);
    }
}
