package leecode;

import common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hujf
 * @title: le147
 * @date 2020/11/9 0009上午 11:11
 * @description: TODO
 */
public class le147 {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }
        Collections.sort(list);
        p=head;
        int i=0;
        while (p!=null){
            p.val=list.get(i++);
            p=p.next;
        }
        return head;
    }
}
