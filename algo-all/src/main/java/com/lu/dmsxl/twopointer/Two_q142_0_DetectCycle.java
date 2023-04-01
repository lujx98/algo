package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-27
 */
public class Two_q142_0_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next.next;
            if (Objects.equals(fast, slow)) {
                slow = head;
                while (!Objects.equals(slow, fast)) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}
