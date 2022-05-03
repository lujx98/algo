package com.lu.algo.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class q94InorderTravesal {


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
        travesal(root.left,result);
        result.add(root.val);
        travesal(root.right,result);
    }

}
