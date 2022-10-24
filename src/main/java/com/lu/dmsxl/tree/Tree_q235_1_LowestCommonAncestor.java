package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-11
 */
public class Tree_q235_1_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root.val > p.val && root.val > q.val) {
//            return lowestCommonAncestor(root.left, p, q);
//        }
//        if (root.val < p.val && root.val < q.val) {
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        return root;
//    }

}
