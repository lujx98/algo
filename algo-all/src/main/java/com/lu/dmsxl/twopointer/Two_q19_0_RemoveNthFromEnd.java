package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class Two_q19_0_RemoveNthFromEnd {

    @Test
    public void test() {
        System.out.println(removeNthFromEnd(ListNodeUtils.makeLinked("[1,2,3,4,5]"), 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (n != 0 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }

}
