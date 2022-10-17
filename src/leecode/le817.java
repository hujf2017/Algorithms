package leecode;

import common.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author hujf
 * @Date 2022/8/18 15:26
 * @Description TODO
 */
public class le817 {

    public int numComponents(ListNode head, int[] nums) {
        int[] num = new int[10001];
        for (int i : nums) {
            num[i] = 1;
        }
        ListNode node = head;
        boolean has = false;
        int count = 0;
        while (node != null) {
            int val = node.val;
            if (num[val] == 1) {
                if (!has) {
                    has = true;
                }
            } else {
                if (has) {
                    count++;
                    has = false;
                }
            }
            node = node.next;
        }
        if (has) {
            return count + 1;
        }
        return count;

    }


    public int numComponents2(ListNode head, int[] nums) {
        ListNode node = head;
        boolean zero = false;
        int[] numx = new int[10001];
        for (int i : nums) {
            numx[i] = 1;
        }
        int count = 0;
        while (node != null) {
            int val = node.val;
            if (numx[val] ==0) {
                if (!zero) {
                    count++;
                    zero = true;
                }
            } else {
                zero = false;
            }
            node = node.next;
        }

        if(numx[head.val]==0){
            count--;
        }

        return zero?count:count+1;
    }


    @Test
    public void t() {

    }
}
