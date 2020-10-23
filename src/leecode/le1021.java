package leecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hujf
 * @title: le1021
 * @date 2020/9/12 0012下午 2:44
 * @description: TODO
 */
public class le1021 {




    public String findLongestWord(String s, List<String> d) {
        String str="";
        for(String sstr:d){
            for(int i=0,j=0;i<s.length()&&j<sstr.length();i++){
                if(s.charAt(i)==sstr.charAt(j)) {
                    j++;
                }
                if(j==sstr.length()){
                    if(sstr.length()>str.length()||(sstr.length()==str.length()&&str.compareTo(sstr)>0)) {
                        str=sstr;
                    }
                }
            }
        }
        return str;
    }
}
