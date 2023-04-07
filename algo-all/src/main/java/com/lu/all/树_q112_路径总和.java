package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class 树_q112_路径总和 {

    @Test
    public void test() {
        System.out.println(hasPathSum(TreeUtils.makeTree("[1,2]"), 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return extracted(root, targetSum);
    }

    private boolean extracted(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        if ((root.left != null && extracted(root.left, targetSum - root.val)) ||
                (root.right != null && extracted(root.right, targetSum - root.val))) {
            return true;
        }
        return false;
    }

//    private int count = 0;
//    private boolean res = false;
//
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        travesal(root, targetSum);
//        return res;
//    }
//
//    public void travesal(TreeNode root, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        count += root.val;
//        if (root.left == null && root.right == null && count == targetSum) {
//            res = true;
//        }
//        if (root.left != null) travesal(root.left, targetSum);
//        if (root.right != null) travesal(root.right, targetSum);
//        count -= root.val;
//    }

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        } else if (root.right == null && root.left == null) {
//            return root.val == targetSum;
//        }
//        return hasPathSum(root.left, targetSum, root.val) || hasPathSum(root.right, targetSum, root.val);
//    }
//
//    private boolean hasPathSum(TreeNode root, int targetSum, int current) {
//        if (root == null) {
//            return false;
//        }
//        current += root.val;
//        if (root.left == null && root.right == null) {
//            return current == targetSum;
//        }
//        return hasPathSum(root.left, targetSum, current) || hasPathSum(root.right, targetSum, current);
//    }

}
