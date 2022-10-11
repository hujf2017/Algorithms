package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/11 9:44
 * @Description "qgqeg"
 * "gqgeq"
 */
public class le1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int index =-1;
        int count =0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=chars1[i]){
                count++;
                if(index==-1){
                    index = i;
                } else if (index>100) {
                    return false;
                } else {
                    if(chars[i]==chars1[index]&&chars[index]==chars1[i]){
                        index =101;
                    }else {
                        return false;
                    }
                }
            }
        }
        if(count!=2){
            return false;
        }else {
            return true;
        }
    }

    @Test
    public void x(){
        areAlmostEqual("aa","ac");
    }
}
