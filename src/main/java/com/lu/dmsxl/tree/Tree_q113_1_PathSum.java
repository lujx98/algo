package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.JacksonUtil;
import com.lu.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class Tree_q113_1_PathSum {

    @Test
    public void test(){
        System.out.println(JacksonUtil.toJson(pathSum(TreeUtils.makeTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22)));
    }

    public LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backTracking(root, targetSum);
        return res;
    }

    public void backTracking(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        path.offer(root.val);
        if (root.right == null && root.left == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        backTracking(root.left, target);
        backTracking(root.right, target);
        target += root.val;
        path.removeLast();
    }

//    public LinkedList path;
//    public List<List<Integer>> result;
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        this.result = new ArrayList<>();
//        this.path = new LinkedList();
//        travesal(root, targetSum);
//        return result;
//    }
//
//    public void travesal(TreeNode root, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        path.offer(root.val);
//        targetSum -= root.val;
//        if (root.right == null && root.left == null) {
//            if (targetSum == 0) {
//                result.add(new LinkedList<>(path));
//            }
//        }
//        if (root.left != null) {
//            travesal(root.left, targetSum);
//        }
//        if (root.right != null) {
//            travesal(root.right, targetSum);
//        }
//        path.removeLast();
//    }
//
}
