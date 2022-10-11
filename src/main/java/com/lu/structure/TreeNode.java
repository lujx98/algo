package com.lu.structure;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sheldon
 * @date 2022-04-04
 */
@Data
@Accessors(chain = true)
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}
