package com.lu.algo.tree.bts;

import org.checkerframework.framework.qual.Covariant;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-05-09
 */
public class q501FindMode {

    private class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    private int maxcount;
    private int count;
    private ArrayList<Integer> result = new ArrayList<>();
    private TreeNode previousNode = null;

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (previousNode == null || previousNode.val != root.val) {
            count = 1;
        } else {
            count ++;
        }

        if (count>maxcount) {
            maxcount = count;
            result.clear();
            result.add(root.val);
        }else if (count == maxcount){
            result.add(root.val);
        }

        previousNode = root;
        traversal(root.right);
    }

}
