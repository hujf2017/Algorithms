package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/3 9:21
 * @Description TODO
 */
public class le899 {
    public String orderlyQueue(String s, int k) {
        String min = s;
        StringBuilder stringBuilder = new StringBuilder();
        if(k==1){
            stringBuilder.append(s);
            for(int i=0;i<s.length();i++){
                String substring = stringBuilder.substring(0, 1);
                StringBuilder stringBuilder1 = stringBuilder.deleteCharAt(0);
                StringBuilder append = stringBuilder1.append(substring);
                if(min.compareTo(append.toString())>0){
                    min = append.toString();
                }
            }
            return min;
        }else {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for(int i=0;i<chars.length;i++){
                stringBuilder.append(chars[i]);
            }
            return stringBuilder.toString();
        }
    }


    @Test
    public void t(){
        System.out.println(orderlyQueue("cba", 2));
    }
}
