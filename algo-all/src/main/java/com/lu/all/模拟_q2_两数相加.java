package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author sheldon
 * @date 2023-07-03
 */
public class 模拟_q2_两数相加 {

    @Test
    public void test() {
        System.out.println(addTwoNumbers(ListNodeUtils.makeLinked("[9]"), ListNodeUtils.makeLinked("[1,9,9,9,9,9,9,9,9,9]")));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
