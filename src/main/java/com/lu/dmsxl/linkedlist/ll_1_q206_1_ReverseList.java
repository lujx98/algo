package com.lu.dmsxl.linkedlist;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2022-12-10
 */
public class ll_1_q206_1_ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return head;
    }

}
