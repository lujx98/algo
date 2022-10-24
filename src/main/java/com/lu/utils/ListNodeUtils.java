package com.lu.utils;

import com.lu.structure.ListNode;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class ListNodeUtils {

    public ListNode makeLinked(String a) {
        a = a.trim();
        if (a.startsWith("[")) {
            a = a.substring(1, a.length() - 1);
        }
        String[] split = a.split(",");
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        listNode.val = Integer.valueOf(split[0]);
        for (int i = 1; i < split.length; i++) {
            listNode.next = new ListNode(Integer.valueOf(split[i]));
            listNode = listNode.next;
        }
        return temp;
    }

    @Test
    public void test() {
        System.out.println(JacksonUtil.toJson(makeLinked("[1,2,3]")));
    }

}
