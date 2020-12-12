package leecode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le859
 * @date 2020/12/10 0010下午 12:11
 * @description: TODO
 */
public class le859 {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        int num =0;
        char []a = A.toCharArray();
        char []b = B.toCharArray();
        //整俩set存放内容
        Set set = new HashSet();
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        for(int i=0;i<a.length;i++){
            //第一步 把set放进来
            set.add(a[i]);
            if(a[i]!=b[i]){
                if(set1.size()==2){
                    return false;
                }
                set1.add(a[i]);
                set2.add(b[i]);
            }
        }
        //butong
        if(!set1.containsAll(set2)){
            return false;
        }
        if(A.equals(B)&&set.size()==A.length()){
            return false;
        }

        return true;

    }
    @Test
    public void t(){
        buddyStrings("","aa");
    }
}
