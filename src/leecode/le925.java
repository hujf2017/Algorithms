package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le925
 * @date 2020/10/21 0021上午 9:37
 * @description: TODO
 */
public class le925 {
    public boolean isLongPressedName(String name, String typed) {
        char ax[]= name.toCharArray();
        char ax2[] = typed.toCharArray();
        int count =0;
        int i;
        int has=0;
        char last=ax[0];
        boolean is =true;
        for( i=0;i<name.length();i++){
            char ch =ax[i];
            while(count<typed.length()){
                if(ax2[count]==ch){
                    count++;
                    has++;
                    last = ch;
                    break;
                }else{
                   if(ax2[count]!=last) {
                       return false;
                   }
                }
                count++;
            }
        }
        if(has==name.length()){
            while(count<typed.length()){
                if(ax2[count]!=last){
                    return false;
                }
                count++;
            }
            return true;
        }else{
            return false;
        }
    }
    @Test
    public void test(){
        System.out.println(isLongPressedName("abcd","aaabbbcccddd"));
    }
}
