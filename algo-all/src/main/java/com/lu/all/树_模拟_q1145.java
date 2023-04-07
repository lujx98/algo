package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-03
 */
public class 树_模拟_q1145 {

    @Test
    public void test() {
        System.out.println(btreeGameWinningMove(TreeUtils.makeTree("[1,2,3,4,5,6,7,8,9,10,11]"), 11, 3));
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findX(root, x);
        int right = countNode(xNode.right, 0);
        int left = countNode(xNode.left, 0);
        int i = n / 2;
        return left > i || right > i || (n - left - right - 1) > i;
    }

    private int countNode(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        return countNode(node.left, countNode(node.right, count)) + 1;
    }

    private TreeNode findX(TreeNode root, int x) {
        if (root == null || root.val == x) {
            return root;
        }
        TreeNode x1 = findX(root.left, x);
        return x1 == null ? findX(root.right, x) : x1;
    }

}
