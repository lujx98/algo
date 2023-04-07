package com.lu.all;

import com.lu.structure.ListNode;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 模拟_q剑指Offer06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        LinkedList<Integer> objects = new LinkedList<>();
        helper(objects, head);
        return objects.stream().mapToInt(Integer::intValue).toArray();
    }

    private void helper(LinkedList<Integer> objects, ListNode head) {
        objects.addFirst(head.val);
        if (head.next != null) {
            helper(objects, head.next);
        }
    }

}
