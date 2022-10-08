package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

import java.util.*;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class Tree_q144_2_PreorderTravesal {

    public List<Integer> result1 = new ArrayList<Integer>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return result1;
        }
        result1.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return result1;
    }

    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> returnList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek!=null){
                stack.pop();
                if (peek.right!=null) stack.push(peek.right);
                if (peek.left!=null) stack.push(peek.left);
                stack.push(peek);
                stack.push(null);
            }else {
                stack.pop();
                returnList.add(stack.pop().val);
            }
        }

        return returnList;
    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        travesal(root,result);
//        return result;
//    }
//
//    public void travesal(TreeNode root, List<Integer> result){
//        if (root == null) {
//            return;
//        }
//        result.add(root.val);
//        travesal(root.left,result);
//        travesal(root.right,result);
//    }
//
//    public void travesal(TreeNode root){
//        ArrayList<Integer> returnList = new ArrayList<>();
//        if (root==null){
//            return ;
//        }
//        Stack<TreeNode> nodeStack = new Stack<>();
//        nodeStack.push(root);
//        while (!nodeStack.isEmpty()) {
//            TreeNode node = nodeStack.pop();
//            returnList.add(node.val);
//            if (node.right != null){
//                nodeStack.push(node.right);
//            }
//            if (node.left != null){
//                nodeStack.push(node.left);
//            }
//        }
//
//    }

}
