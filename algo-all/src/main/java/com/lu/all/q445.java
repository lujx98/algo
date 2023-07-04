package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-04
 */
public class q445 {

    @Test
    public void test() {
        System.out.println(reverse(ListNodeUtils.makeLinked("[7,2,4,3]")));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers1(reverse(l1), reverse(l2));
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head; // 把下一个节点指向自己
        head.next = null; // 断开指向下一个节点的连接，保证最终链表的末尾节点的 next 是空节点
        return newHead;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        boolean over = false;
        while (l1 != null || l2 != null) {
            int curCount = over ? 1 : 0;
            over = false;
            if (l1 != null) {
                curCount += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curCount += l2.val;
                l2 = l2.next;
            }
            if (curCount >= 10) {
                over = true;
                curCount -= 10;
            }
            cur.next = new ListNode(curCount);
            cur = cur.next;
        }
        if (over) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

}
