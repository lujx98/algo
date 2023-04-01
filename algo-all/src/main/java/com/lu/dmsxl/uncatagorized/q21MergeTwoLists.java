package com.lu.dmsxl.uncatagorized;

import com.lu.structure.ListNode;

/**
 * @author sheldon
 * @date 2022-09-16
 */
public class q21MergeTwoLists {

    private ListNode node = new ListNode();

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int i1 = list1 != null ? list1.val : -101;
        int i2 = list2 != null ? list2.val : -101;
        if (i1 < i2) {
            node.val = i1;
            list1 = list1.next;
        } else {
            node.val = i2;
            list2 = list2.next;
        }
        node.next = new ListNode();
        node = node.next;
        test(list1,list2);
        return node;
    }

    private void test(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return;
        }
        int i1 = list1 != null ? list1.val : -101;
        int i2 = list2 != null ? list2.val : -101;
        if (i1 < i2) {
            node.val = i1;
            list1 = list1.next;
        } else {
            node.val = i2;
            list2 = list2.next;
        }
        node.next = new ListNode();
        node = node.next;
        test(list1,list2);
    }

}
