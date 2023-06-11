package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-11
 */
public class 前后缀和_q1171_从链表中删去总和值为零的连续节点 {

    @Test
    public void test() {
        System.out.println(removeZeroSumSublists(ListNodeUtils.makeLinked("[0,0]")));
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            boolean deled = helper(cur);
            if (!deled) {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public boolean helper(ListNode cur) {
        ListNode head = cur;
        cur = cur.next;
        int count = 0;
        while (cur != null) {
            count += cur.val;
            if (count == 0) {
                head.next = cur.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
