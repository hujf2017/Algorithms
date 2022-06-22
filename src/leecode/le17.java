package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/6/22 11:06
 * @Description 电话字母组合
 */
public class le17 {
    private static String [][]str = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    List<String> a = new ArrayList();
    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if(chars.length==0){
            return a;
        }
        dfs(new StringBuffer(),chars,0);
        return a;

    }

    private void dfs(StringBuffer stringBuffer,char[] chars,int index) {
        if(index >=chars.length){
            a.add(stringBuffer.toString());
            return;
        }
        int num = chars[index]-48;
        String []s = str[num];

        for(String sx: s){
            stringBuffer.append(sx);
            dfs(stringBuffer,chars,index+1);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

    @Test
    public void te(){
        letterCombinations("23");
    }
}
