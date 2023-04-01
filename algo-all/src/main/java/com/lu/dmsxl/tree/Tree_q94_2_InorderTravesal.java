package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class Tree_q94_2_InorderTravesal {

    @Test
    public void test(){

    }

    public List<Integer> result1 = new ArrayList<Integer>();

    public List<Integer> inorderTravesal(TreeNode root) {
        if (root == null) {
            return result1;
        }
        this.inorderTravesal(root.left);
        result1.add(root.val);
        inorderTravesal(root.right);
        return result1;
    }

    public List<Integer> inorderTravesal1(TreeNode root){
        ArrayList<Integer> returnList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null)stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek == null) {
                stack.pop();
                returnList.add(stack.pop().val);
            }else {
                stack.pop();
                if (peek.right!=null) stack.push(peek.right);
                stack.push(peek);
                stack.push(null);
                if (peek.left!=null) stack.push(peek.left);
            }
        }

        return returnList;
    }

}
