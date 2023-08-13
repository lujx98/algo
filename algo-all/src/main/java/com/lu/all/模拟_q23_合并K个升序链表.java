package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-08-12
 */
public class 模拟_q23_合并K个升序链表 {

    @Test
    public void test(){
        mergeKLists(new ListNode[]{ListNodeUtils.makeLinked("[1,4,5]"),ListNodeUtils.makeLinked("[1,3,4]"),ListNodeUtils.makeLinked("[2,6]")});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (ListNode list : lists) {
            ListNode cur = list;
            while (cur != null) {
                queue.offer(cur.val);
                cur = cur.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ListNode next = new ListNode();
            next.val = poll;
            cur.next = next;
            cur = cur.next;
        }

        return dummy.next;
    }

}
