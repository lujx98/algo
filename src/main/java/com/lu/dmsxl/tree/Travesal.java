package com.lu.dmsxl.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-04-04
 */
public class Travesal {
    public List<Integer> preorderTravesal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.value);
            if (pop.right != null) {
                stack.push(pop.left);
            }
            if (pop.left != null) {
                stack.push(pop.right);
            }
        }
        return result;
    }

    public List<Integer> inordertravesal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = new TreeNode();
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                result.add(currentNode.value);
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    public List<Integer> postordertravesal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.value);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
