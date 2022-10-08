package com.lu.dmsxl.uncatagorized;

import com.lu.structure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q100IsSameTree {

    @Test
    public void test() {
        System.out.println(isSameTree(new TreeNode(1).setLeft(new TreeNode(2)).setRight(new TreeNode(3)), new TreeNode(1).setLeft(new TreeNode(2)).setRight(new TreeNode(3))));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        list1.offer(p);
        list2.offer(q);
        while (!list1.isEmpty() && !list2.isEmpty()) {
            TreeNode node1 = list1.poll();
            TreeNode node2 = list2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (node1.left != null) {
                list1.offer(node1.left);
            }
            if (node1.right != null) {
                list1.offer(node1.right);
            }
            if (node2.left != null) {
                list2.offer(node2.left);
            }
            if (node2.right != null) {
                list2.offer(node2.right);
            }
        }
        return true;
    }

}
