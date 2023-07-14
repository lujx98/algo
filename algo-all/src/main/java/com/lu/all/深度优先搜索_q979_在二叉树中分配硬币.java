package com.lu.all;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2023-07-14
 */
public class 深度优先搜索_q979_在二叉树中分配硬币 {

    private int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int coins = left[0] + right[0] + root.val; // 子树硬币个数
        int nodes = left[1] + right[1] + 1; // 子树节点数
        ans += Math.abs(coins - nodes);
        return new int[]{coins, nodes};
    }

}
