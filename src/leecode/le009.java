package leecode;

/**
 * @author Hujf
 * @title: le009
 * @date 2020/10/28 0028下午 9:02
 * @description: TODO
 */
public class le009 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuffer sx = new StringBuffer(s);
        String xs = sx.reverse().toString();
        if(xs.equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
