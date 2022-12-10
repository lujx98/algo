package com.lu.dmsxl.linkedlist;

import com.lu.dmsxl.uncatagorized.q21MergeTwoLists;
import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2022-12-10
 */
public class ll_7_m0207_1_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode up = headA;
        ListNode down = headB;
        int countUp = 0;
        while (up.next != null) {
            countUp++;
            up = up.next;
        }
        int countDown = 0;
        while (down.next != null) {
            countDown++;
            down = down.next;
        }
        if (up != down) {
            return null;
        }
        ListNode recurse = headA;
        ListNode other = headB;
        if (countDown != countUp) {
            if (countUp > countDown) {
                recurse = headB;
                other= headA;
            }
            for (int i = 0; i < ((countUp - countDown) & Integer.MAX_VALUE); i++) {
                recurse=recurse.next;
            }
        }
        while (recurse != other) {
            recurse=recurse.next;
            other=other.next;
        }
        return recurse;
    }

}
