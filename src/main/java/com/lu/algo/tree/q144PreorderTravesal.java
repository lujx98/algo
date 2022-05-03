package com.lu.algo.tree;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class q144PreorderTravesal {

    @Data
    public class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public Integer val;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        travesal(root,result);
        return result;
    }

    public void travesal(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        result.add(root.val);
        travesal(root.left,result);
        travesal(root.right,result);
    }

    public void travesal(TreeNode root){
        ArrayList<Integer> returnList = new ArrayList<>();
        if (root==null){
            return ;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            returnList.add(node.val);
            if (node.right != null){
                nodeStack.push(node.right);
            }
            if (node.left != null){
                nodeStack.push(node.left);
            }
        }

    }

}
