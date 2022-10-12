package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-12
 */
public class Tree_q404_1_SumOfLeftLeaves {

    @Test
    public void test() {
        System.out.println(sumOfLeftLeaves(TreeUtils.makeTree("[1,2,3,4,5]")));
    }

    public int count = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return count;
        }
        sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            count += root.left.val;
        }
        sumOfLeftLeaves(root.right);
        return count;
    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        return travesal(root);
//    }
//
//    public int travesal(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int shardingResult = 0;
//
//        if (root.left != null && root.left.left== null && root.left.right == null) {
//            shardingResult += root.left.val;
//        }
//
//        shardingResult += travesal(root.left);
//        shardingResult += travesal(root.right);
//
//        return shardingResult;
//    }

}
