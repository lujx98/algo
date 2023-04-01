package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-10-08
 */
public class Tree_q102_1_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.offer(root);
        }
        while (!stack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = stack.size();
            for (int i = size; i > 0; i--) {
                TreeNode pop = stack.poll();
                list.add(pop.val);
                if (pop.left!=null) stack.offer(pop.left);
                if (pop.right!=null) stack.offer(pop.right);
            }
            result.add(list);
        }

        return result;
    }

}
