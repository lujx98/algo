package com.lu.algo.tree.bts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q98IsValidBST {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    private List<Integer> array = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        travesalBST(root);
        return isValidBST();
    }

    private void travesalBST(TreeNode root) {
        if (root.left != null) {
            travesalBST(root.left);
        }
        array.add(root.val);
        if (root.right != null) {
            travesalBST(root.right);
        }
    }

    private boolean isValidBST() {
        int val = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            Integer integer = array.get(i);
            if (integer <= val) {
                return false;
            }
            val = integer;
        }
        return true;
    }

}
