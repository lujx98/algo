package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-11
 */
public class q235LowestCommonAncestor {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
