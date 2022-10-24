package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class Two_q206_1_ReverseList {

    @Test
    public void test() {

    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode cur = head;
        while (next != null) {
            ListNode next1 = next.next;
            next.next = cur;
            cur = next;
            next = next1;
        }
        return next;
    }

}
