package com.lu.all;

import com.lu.structure.TreeNode;

import java.util.HashMap;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_记忆化搜索_树的记忆化搜索_用散列表来做memo_q337_打家劫舍III {

    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int res = root.val
                + (root.left == null ? 0 : dfs(root.left.right) + dfs(root.left.left))
                + (root.right == null ? 0 : dfs(root.right.left) + dfs(root.right.right));
        res = Math.max(res, dfs(root.left) + dfs(root.right));
        memo.put(root, res);
        return res;
    }

}
