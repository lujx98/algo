package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.utils.ListNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-04-10
 */
public class rev_单调栈_q1019_链表中的下一个更大节点 {

    @Test
    public void test(){
        System.out.println(Arrays.toString(nextLargerNodes(ListNodeUtils.makeLinked("[2,7,4,3,5]"))));
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        List<Integer> res = new ArrayList<>();
        while (right.next != null) {
            while (right.next != null && right.next.val > right.val) {
                right = right.next;
            }
            while (left != right) {
                res.add(right.val);
                left = left.next;
            }
        }
        res.add(0);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
