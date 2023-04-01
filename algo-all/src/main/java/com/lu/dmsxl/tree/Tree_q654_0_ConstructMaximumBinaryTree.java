package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class Tree_q654_0_ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return travesal(nums, 0, nums.length);
    }

    private TreeNode travesal(int[] nums, int left, int right) {
        if (right - left < 1) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = left;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = travesal(nums, left, maxIndex);
        root.right = travesal(nums, maxIndex + 1, right);
        return root;
    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        int index = 0;
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > maxValue) {
//                maxValue = nums[i];
//                index = i;
//            }
//        }
//        TreeNode root = new TreeNode(maxValue);
//        travesal(root, nums, 0, index - 1, true);
//        travesal(root, nums, index + 1, nums.length - 1, false);
//        return root;
//    }
//
//    private void travesal(TreeNode root, int[] nums, int left, int right, boolean isLeft) {
//        if (left >= right) {
//            return;
//        }
//
//        int index = 0;
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = left; i <= right; i++) {
//            if (nums[i] > maxValue) {
//                maxValue = nums[i];
//                index = i;
//            }
//        }
//
//        TreeNode node = new TreeNode(maxValue);
//        if (isLeft) {
//            root.left = node;
//        } else {
//            root.right = node;
//        }
//        travesal(root, nums, left, index - 1, true);
//        travesal(root, nums, index + 1, right, false);
//    }

}
