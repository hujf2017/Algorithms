package leecode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le877
 * @date 2021-06-16 8:36
 * @description: 给一个数组 偶数个数，  A 和 B   A 先开始 从开始或者结尾取走一个数 B从中哪一个数  问最后谁的石头多
 */
public class le877 {
    public boolean stoneGame(int[] piles) {
        int sumA = 0;
        int sumB = 0;
        int count = 0;
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < piles.length; i++) {
            linkedList.add(piles[i]);
        }
        while (count < piles.length) {
            int tmp;
            if (linkedList.getFirst() > linkedList.getLast()) {
                tmp = linkedList.pollFirst();
            } else {
                tmp = linkedList.pollLast();
            }

            if (count % 2 == 0) {
                sumA += tmp;
            } else {
                sumB += tmp;
            }
            count++;
        }

        if (sumA > sumB) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void t(){
        stoneGame(new int[]{3,2,10,4});
    }


    @Test
    public void t2(){
        long a = 1066644051;
        long b = 1096579831;
        long c = 198959462;
       System.out.println(b-a+c);
    }
}
