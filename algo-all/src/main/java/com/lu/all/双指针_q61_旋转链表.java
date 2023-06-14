package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-14
 */
public class 双指针_q61_旋转链表 {

    @Test
    public void test() {
        System.out.println(rotateRight(ListNodeUtils.makeLinked("[1,2,3,4,5]"), 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        k %= count;

        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        ListNode left = head;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        ListNode res = left.next;
        left.next = null;
        right.next = head;

        return res;
    }

}
