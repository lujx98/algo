package com.lu.dmsxl;

import com.lu.ListNode;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class Dpointer_q141_2_HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
