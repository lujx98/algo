package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class q108SortedArrayToBST {

    public class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }

        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + right / 2 - left / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, left, mid);
        treeNode.right = sortedArrayToBST(nums, mid + 1, right);
        return treeNode;
    }

}
