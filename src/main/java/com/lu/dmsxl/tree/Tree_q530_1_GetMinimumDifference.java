package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-08
 */
public class Tree_q530_1_GetMinimumDifference {

    @Test
    public void test(){
        System.out.println(getMinimumDifference(TreeUtils.makeTree("[4,2,6,1,3]")));
    }

    private TreeNode pre;
    private Integer min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travesal(root);
        return min;
    }

    private void travesal(TreeNode root) {
        if (root == null) {
            return ;
        }

        travesal(root.left);
        if (pre != null) {
            min = Math.min(min,Math.abs(pre.val-root.val));
        }
        pre = root;
        travesal(root.right);
    }

//
//    private int min = Integer.MAX_VALUE;
//    private TreeNode previousNode;
//
//    public int getMinimumDifference(TreeNode root) {
//        travesalTree(root);
//        return min;
//    }
//
//    private void travesalTree(TreeNode root) {
//        //todo ： 难以理解
//        if (root == null) {
//            return ;
//        }
//        travesalTree(root.left);
//        if (previousNode != null) {
//            int abs = Math.abs(root.val - previousNode.val);
//            if (abs < min) {
//                min = abs;
//            }
//        }
//        previousNode = root;
//        travesalTree(root.right);
//    }

    /**
     * 分割
     */

//    private void travesalTree(TreeNode root) {
//        if (root.left != null) {
//            previousNode = root;
//            travesalTree(root.left);
//        }
//        if (previousNode != root) {
//            int abs = Math.abs(root.val - previousNode.val);
//            if (abs < min) {
//                min = abs;
//            }
//        }
//        if (root.right != null) {
//            previousNode = root;
//            travesalTree(root.right);
//        }
//    }

}
