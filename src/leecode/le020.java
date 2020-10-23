package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le020
 * @date 2020/9/24 0024下午 6:14
 * @description: TODO
 */
public class le020 {
    public boolean isValid(String s) {
        Deque<Character> lis = new LinkedList();
        char[] sx = s.toCharArray();
        if(s.length()%2!=0){
            return false;
        }
        for(int i=0;i<sx.length;i++){
            if(sx[i]=='{'||sx[i]=='['||sx[i]=='('){
                lis.push(sx[i]);
            }else{
                if(lis.size()==0){
                    return false;
                }
                char ss = lis.pop();
                if(ss+sx[i]!=248&&ss+sx[i]!=184&&ss+sx[i]!=81){
                    return false;
                }
            }
        }
        if(lis.size()>0){
            return false;
        }
        return true;
    }

}
