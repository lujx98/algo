package com.lu.utils;

import com.lu.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-10-08
 */
public class TreeUtils {

    /**
     * [1,2,2,3,4,4,3]
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static TreeNode makeTree(String str) {
        String substring = str;
        if (str.startsWith("[") && str.endsWith("]")) {
            substring = str.substring(1, str.length() - 1);
        }
        LinkedList<Integer> intQueue = new LinkedList(convertToList(substring));
        LinkedList<TreeNode> curQueue = new LinkedList<>();
        LinkedList<TreeNode> preQueue = new LinkedList<>();
        TreeNode head = new TreeNode();
        head.val = intQueue.poll();
        preQueue.offer(head);
        while (!intQueue.isEmpty()) {
            while (!preQueue.isEmpty()) {
                TreeNode poll = preQueue.poll();
                Integer a = intQueue.poll();
                if (a != null) {
                    TreeNode left = new TreeNode(a);
                    poll.left = left;
                    curQueue.offer(left);
                }
                Integer b = intQueue.poll();
                if (b != null) {
                    TreeNode right = new TreeNode(b);
                    poll.right = right;
                    curQueue.offer(right);
                }
            }
            preQueue = (LinkedList<TreeNode>) curQueue.clone();
            curQueue.clear();
        }
        return head;
    }

    private static Collection<Integer> convertToList(String substring) {
        ArrayList<Integer> objects = new ArrayList<>();
        String[] split = substring.split(",");
        for (String s : split) {
            if (s == "null") {
                objects.add(null);
                continue;
            }
            objects.add(Integer.parseInt(s));
        }
        return objects;
    }

    public static void main(String[] args) {
        makeTree("[1,2,2,3,4,4,3]");
    }

}
