package com.lu.all;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2023-08-05
 */
public class 模拟_q21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            ListNode next;
            if (list1 == null || list2 == null) {
                if (list1 == null) {
                    next = list2;
                    list2 = list2.next;
                } else {
                    next = list1;
                    list1 = list1.next;
                }
            } else {
                if (list1.val < list2.val) {
                    next = list1;
                    list1 = list1.next;
                } else {
                    next = list2;
                    list2 = list2.next;
                }
            }
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;
    }

}
