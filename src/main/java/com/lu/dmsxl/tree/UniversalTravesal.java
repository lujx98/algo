package com.lu.dmsxl.tree;

import com.lu.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class UniversalTravesal {
    public List<Integer> preoderTravesal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }else {
                stack.pop();
                TreeNode val = stack.pop();
                result.add(val.val);
            }
        }
        return result;
    }
}
