package com.lu.dmsxl.uncatagorized;

import com.lu.structure.ListNode;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q93DeleteDuplicates {

    @Test
    public void test(){
        deleteDuplicates(new ListNode(1).setNext(new ListNode(1).setNext(new ListNode(2))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
