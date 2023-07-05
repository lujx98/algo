package com.lu.all;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2023-07-05
 */
public class 模拟_q剑指Offer24_反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
