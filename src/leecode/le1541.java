package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le1541
 * @date 2020/11/27 0027上午 9:32
 * @description: TODO
 */
public class le1541 {
    private char c1 = '(';

    public int minInsertions(String s) {
        char[] ch = s.toCharArray();
        int needCount=0;
        Deque d1= new LinkedList();
        Deque d2= new LinkedList();
        for(char c:ch){
            if(c==c1){
                //上一个
                if(d2.size()==1){
                    d2.clear();
                    if(d1.size()>0){
                        d1.pop();
                        needCount++;
                    }else{
                        needCount+=2;
                    }

                }
                d1.add(c);
            }else{
                d2.add(c);
            }
            //如果后面俩出现2个
            if(d2.size()==2){
                d2.clear();
                if(d1.size()>0){
                    d1.pop();
                }else{
                    needCount++;
                }
            }
        }

        if(d1.size()==0&&d2.size()==1){
            return needCount+2;
        }
        return needCount+d1.size()*2-d2.size();
    }


    @Test
    public void t(){
        System.out.println(minInsertions("(()))(()))()())))"));
    }
}
