package leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/1 17:16
 * @Description TODO
 */
public class le241 {

    public List<Integer> diffWaysToCompute(String expression) {
        HashSet set = new HashSet();
        set.add('-');
        set.add('+');
        set.add('*');
        char[] chars = expression.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> listc = new ArrayList<>();
        for(char x :chars){
            if(set.contains(x)){
                listc.add(x);
            }else{
                list.add(x);
            }

        }
        int num0= list.get(0);
        for(int i=0;i<list.size();i++){

        }

        return new ArrayList<>();
    }
}
