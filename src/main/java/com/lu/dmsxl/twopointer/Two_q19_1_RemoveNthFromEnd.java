package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class Two_q19_1_RemoveNthFromEnd {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;
        int count = 0;
        while (right.next != null) {
            if (!(count == n)) {
                left = left.next;
            }
            left = right;
            right = right.next;
            count++;
        }
        return head;
    }

}
