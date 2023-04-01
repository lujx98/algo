package com.lu.dmsxl.linkedlist;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-10
 */
public class ll_1_q19_1_RemoveNthFromEnd {

    @Test
    public void test() {
        removeNthFromEnd(ListNodeUtils.makeLinked("[1,2,3,4,5]"), 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode recurseNode = head;
        int count = 1;
        while (recurseNode.next != null) {
            count++;
            recurseNode = recurseNode.next;
        }
        int times = count - n + 1;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        for (int i = 0; i < times; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = cur.next;
        return dummy.next;
    }

}
