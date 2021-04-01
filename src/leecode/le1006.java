package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Hujf
 * @title: le1006
 * @date 2021/4/114:10
 * @description: TODO
 */
public class le1006 {
    public int clumsy(int N) {
        int sum=0;
        int flag=0;
        Deque<Integer> stack = new LinkedList();
        for(int i=N;i>0;i--){
            switch (flag%4){
                case 0: sum+=i;break;
                case 1:sum*=i;break;
                case 2:sum/=i;break;
                default:
                    if(stack.isEmpty()){
                        stack.add(sum);
                        stack.add(i);
                        sum=0;
                    }else{
                        stack.add(-sum);
                        stack.add(i+0);
                        sum=0;
                    }

            }
            flag++;
        }
        if(stack.isEmpty()){
            return sum;
        }
        stack.add(-sum);
        int s=0;
        for(int d:stack){
            s+=d;
        }
        return s;
    }

    @Test
    public void t(){
        clumsy(3);
    }
}
