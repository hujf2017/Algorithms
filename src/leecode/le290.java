package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hujf
 * @title: le290
 * @date 2020/12/16 0016下午 4:50
 * @description: TODO
 */
public class le290 {
    public boolean wordPattern(String pattern, String s) {
        Map m = new HashMap();
        String []ss = s.split(" ");
        char [] a = pattern.toCharArray();
        if(a.length!=ss.length){
            return false;
        }
        Set set = new HashSet<>();
        Set set1 = new HashSet<>();
        for(int i=0;i<a.length;i++){
            if(!m.containsKey(a[i])){
                m.put(a[i],ss[i]);
                set.add(a[i]);
                set1.add(ss[i]);
            }else{
                if(!m.get(a[i]).equals(ss[i])){
                    return false;
                }
            }
        }
        if(set.size()!=set1.size()){
            return false;
        }
        return true;
    }

    @Test
    public void t(){
        wordPattern("abba","dog dog dog dog");
    }
}
