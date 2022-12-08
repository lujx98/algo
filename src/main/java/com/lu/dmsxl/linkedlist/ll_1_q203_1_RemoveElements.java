package com.lu.dmsxl.linkedlist;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2022-12-08
 */
public class ll_1_q203_1_RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null && head.val != val) {
            return head;
        }
        ListNode curr = head;
        ListNode listNode = new ListNode(-1, head);
        ListNode prev = listNode;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

        }
        return listNode.next;
    }

}
