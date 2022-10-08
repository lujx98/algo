package com.lu.dmsxl.uncatagorized;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-15
 */
public class q2AddTwoNumbers {

    @Data
    @Accessors(chain = true)
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void tet() {
        ListNode listNode = new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3)));
        ListNode listNode1 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
        System.out.println(addTwoNumbers(listNode, listNode1));
    }

    private ListNode current;
    private final ListNode head = new ListNode();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        head.val = val >= 10 ? val - 10 : val;
        current = head;
        test(l1.next, l2.next, val >= 10);
        return head;
    }

    private void test(ListNode l1, ListNode l2, boolean b) {
        if (l1 == null && l2 == null&&!b) {
            return;
        }
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (b ? 1 : 0);
        boolean b1 = val >= 10;
        current.next = new ListNode(b1 ? val - 10 : val);
        current = current.next;
        test(l1==null?null:l1.next, l2==null?null:l2.next, b1);
    }

}
