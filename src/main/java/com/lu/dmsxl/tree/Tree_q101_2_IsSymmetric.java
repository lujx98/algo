package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-10-08
 */
public class Tree_q101_2_IsSymmetric {

    @Test
    public void test(){
        System.out.println(isSymmetric1(TreeUtils.makeTree("[1,2,2,3,4,4,3]")));
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if ((left == null && right != null) ||
                (left != null && right == null)
        ) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if ((left.val != right.val)){
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> ints = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                ints.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            if (isSymmetric(ints)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric(ArrayList<Integer> ints) {
        int left = 0;
        int right = ints.size() - 1;
        while (left < right) {
            if (ints.get(left) != ints.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
