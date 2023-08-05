package com.lu.all;

import com.lu.structure.ListNode;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-27
 */
public class 模拟_q142_环形链表II {

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> objects = new HashSet<>();
        while (head.next != null) {
            if (objects.contains(head)) {
                return head;
            }
            objects.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next.next;
            if (Objects.equals(fast, slow)) {
                slow = head;
                while (!Objects.equals(slow, fast)) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}
