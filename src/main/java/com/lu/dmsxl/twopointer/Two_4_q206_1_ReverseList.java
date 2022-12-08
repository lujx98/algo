package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class Two_4_q206_1_ReverseList {

    @Test
    public void test() {
        reverseList(ListNodeUtils.makeLinked("[1,2,3,4,5]"));
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
