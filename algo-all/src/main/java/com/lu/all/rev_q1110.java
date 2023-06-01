package com.lu.all;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-05-30
 */
public class rev_q1110 {

    @Test
    public void test() {
        System.out.println(delNodes(TreeUtils.makeTree("[1,2,null,4,3]"), new int[]{2, 3}));
    }

    private final List<TreeNode> res = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        TreeNode treeNode = new TreeNode(to_delete[0]);
        treeNode.right = root;
        dfs(treeNode);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (set.contains(root.val)) {
            if (root.right != null && !set.contains(root.right.val)) {
                res.add(root.right);
            }
            if (root.left != null && !set.contains(root.left.val)) {
                res.add(root.left);
            }
        }
        if (root.left != null) {
            TreeNode left = root.left;
            if (set.contains(left.val)) {
                root.left = null;
            }
            dfs(left);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            if (set.contains(right.val)) {
                root.right = null;
            }
            dfs(right);
        }
    }

}
