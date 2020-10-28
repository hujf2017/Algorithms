package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le686重复叠加字符串匹配
 * @date 2020/10/27 0027下午 4:45
 * @description: TODO
 */
public class le686重复叠加字符串匹配 {
    public int repeatedStringMatch(String a, String b) {
        int num1 = a.indexOf(b.charAt(0));
        if(num1==-1){
            return num1;
        }
        if(a.contains(b)){
            return 1;
        }
        int count = 0;
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)==a.charAt((num1+i)%a.length())){
                count++;
            }else{

            }
        }
        return (count+num1)%a.length()==0?(count+num1)/a.length():(count+num1)/a.length()+1;
    }

    @Test
    public void t(){
        repeatedStringMatch("abcabcabcabc","abac");
    }
}
