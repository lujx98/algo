package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-08
 */
public class Two_5_q24_1_SwapPairs {

    @Test
    public void test() {
        swapPairs1(ListNodeUtils.makeLinked("[1,2,3,4]"));
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode left = prev.next;
            ListNode right = prev.next.next;
            ListNode next = right.next;
            prev.next = right;
            right.next = left;
            prev = left;
            left.next = next;
        }

        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        //todolu:
        if (head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (left != null && right != null) {
            ListNode next = right.next;
            if (next == null) {
                right.next = left;
                return right;
            }
            if (next.next == null) {
                right.next = left;
                next.next = right;
                return next;
            }
            right.next = left;
            left.next = next;
            left = next;
            right = next.next;
        }
        return null;
    }

}
