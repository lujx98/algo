package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-12-15
 */
public class 树_dfs_q2415_反转二叉树的奇数层 {

    @Test
    public void test() {
        reverseOddLevels(TreeUtils.makeTree("[2,3,5,8,13,21,34]"));
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(1, root.left, root.right);
        return root;
    }

    private void dfs(int flag, TreeNode left, TreeNode right) {
        if (left == null) {
            return;
        }
        if (flag == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(flag ^ 1, left.left, right.right);
        dfs(flag ^ 1, left.right, right.left);
    }

}
