package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-18
 */
public class 树_q1026_节点与其祖先之间的最大差值 {

    @Test
    public void test() {
        System.out.println(maxAncestorDiff(TreeUtils.makeTree("[8,3,10,1,6,null,14,null,null,4,7,13]")));
    }

    public int maxAncestorDiff(TreeNode root) {
        return Math.max(helper(root.left, root.val, root.val), helper(root.right, root.val, root.val));
    }

    private int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int cur = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        return Math.max(cur, Math.max(helper(root.left, Math.min(root.val,min), Math.max(root.val,max))
                , helper(root.right, Math.min(root.val,min), Math.max(root.val,max))));
    }

}
