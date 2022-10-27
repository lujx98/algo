package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class Tree_q108_1_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return test(nums, 0, nums.length);
    }

    private TreeNode test(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        //todolu:左右区间
//        treeNode.left = test(nums, left, mid - 1);
//        treeNode.right = test(nums, mid + 1, right);
        treeNode.left = test(nums, left, mid);
        treeNode.right = test(nums, mid + 1, right);
        return treeNode;
    }


//    public TreeNode sortedArrayToBST(int[] nums) {
//        return sortedArrayToBST(nums, 0, nums.length);
//    }
//
//    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
//        if (left >= right) {
//            return null;
//        }
//        if (right - left == 1) {
//            return new TreeNode(nums[left]);
//        }
//        int mid = left + right / 2 - left / 2;
//        TreeNode treeNode = new TreeNode(nums[mid]);
//        treeNode.left = sortedArrayToBST(nums, left, mid);
//        treeNode.right = sortedArrayToBST(nums, mid + 1, right);
//        return treeNode;
//    }

}
