package com.lu.daily;

import com.lu.structure.ListNode;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-30
 */
public class q1669_模拟_链表 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode node1 = dummy;
        ListNode node2 = dummy.next;
        for (int i = 0; i <= b; i++) {
            if (i < a) {
                node1 = node1.next;
            }
            node2 = node2.next;
        }
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        node1.next = list2;
        tail2.next = node2;
        return dummy.next;
    }

}
