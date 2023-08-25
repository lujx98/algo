package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-25
 */
public class 模拟_q1448_统计二叉树中好节点的数目 {

    @Test
    public void test(){
        goodNodes(TreeUtils.makeTree("[9,null,3,6]"));
    }

    public int goodNodes(TreeNode root) {
        return dfs(root.left, root.val) + dfs(root.right, root.val) + 1;
    }

    private int dfs(TreeNode root, Integer max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            return dfs(root.left, Math.max(max,root.val)) + dfs(root.right, Math.max(max,root.val)) + 1;
        }
        return dfs(root.left, Math.max(max,root.val)) + dfs(root.right, Math.max(max,root.val));
    }

}
