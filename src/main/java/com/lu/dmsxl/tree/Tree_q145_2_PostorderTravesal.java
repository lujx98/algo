package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class Tree_q145_2_PostorderTravesal {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null)stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek == null) {
                stack.pop();
                returnList.add(stack.pop().val);
            }else {
                stack.push(null);
                if (peek.right!=null) stack.push(peek.right);
                if (peek.left!=null) stack.push(peek.left);
            }
        }

        return returnList;
    }

}
