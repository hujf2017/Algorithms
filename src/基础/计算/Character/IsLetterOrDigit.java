package 基础.计算.Character;

import org.junit.Test;

/**
 * @author Hujf
 * @title: IsLetterOrDigit
 * @date 2020/12/22 0022上午 9:18
 * @description: TODO
 */
public class IsLetterOrDigit {

    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c: ch){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String s1 = sb.toString();
        return s1.equals(sb.reverse().toString());
    }

    @Test
    public void t(){
        isPalindrome("A man, a plan, a canal: Panama");
    }
}
