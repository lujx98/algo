package com.lu.dmsxl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-04-04
 */
public class IterativeTravesal {

    public static List<Integer> preorderTravelsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static List<Integer> inorderTravelsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.value);
        inorder(root.right, result);
    }

    public static List<Integer> postorderTravelsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.value);
    }

}
