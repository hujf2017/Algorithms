package leecode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hujf
 * @title: le514
 * @date 2020/11/11 0011下午 5:44
 * @description: TODO
 */
public class le514 {
    Deque<Character> que =  new ArrayDeque<>();
    int num3 =0;
    public int findRotateSteps(String ring, String key) {

        char ch[] = ring.toCharArray();
        for(char c:ch){
            que.add(c);
        }
        int len  = que.size();
        int i=0;
        for(char k:key.toCharArray()){
            //1.找到当前最近的k  1 顺时针转， 2逆时针转
           int order = find_c(que,key.toCharArray(),i);
            //2.对这个k进行移动 得到修改后的队列和最短移动次数
            int nums = Move1(que,order,k);
            num3+=nums+1;
            i++;
        }
        return num3;
    }

    private int Move1(Deque<Character> que, int order,char k) {
        int num = 0;
        if(order==1){
           while(que.getFirst()!=k){
               char asd = que.getFirst();
               que.pollFirst();
               que.addLast(asd);
               num++;
           }
        }else{
            while(que.getFirst()!=k){
                char asd = que.getLast();
                que.pollLast();
                que.addFirst(asd);
                num++;
            }
        }
        return num;
    }

    private int find_c(Deque<Character> que, char[] k,int i) {
        int num = 0;
        int local = que.size();
        int order = 1;
        boolean istwo =false;
        for(char a:que){
            if(k[i]==a){
                local = Math.min(local,Math.min(num,que.size()-num));
                if(num>(que.size()-num)&&num>local){
                    order =2;
                }
                if(istwo&&local==que.size()-num){
                    order = find_c(que,k,++i);
                }
                istwo =true;
            }
            num++;
        }
        return order;
    }
    @Test
    public void t(){
        findRotateSteps("ababcab","acbaacba");
    }
}
