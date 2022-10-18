package 基础.集合;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author hujf
 * @Date 2022/10/17 10:54
 * @Description TODO
 */
public class PriorityQ {

    @Test
    public void t(){
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0;i<100;i++){
            queue.add((int) (Math.random()*10));

            int num1 =0;
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
