package leecode;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le143
 * @date 2020/10/20 0020下午 12:33
 * @description: TODO
 */
public class le143 {
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        Deque<ListNode> que = new LinkedList();
        ListNode now = head;
        while(now!=null){
            que.add(now);
            now = now.next;
        }
        int a = que.size();
        int ax =0;
        now = head;
        head =now;
        if(a%2==0){
            while(ax<a/2 ) {
                ListNode now1 = now.next;
                ListNode now2 = que.pollLast();
                now.next = now2;
                now2.next = now1;
                now =now1;
                ax++;
            }
            now.next.next =null;
        }else{
            while(ax<a/2) {
                ListNode now1 = now.next;
                ListNode now2 = que.pollLast();
                now.next = now2;
                now2.next = now1;
                now =now1;
                ax++;
            }
            now.next=null;
        }
    }
}
