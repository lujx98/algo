package com.lu.daily;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-06
 */
public class 模拟_计算布尔二叉树的值_q2331 {

    @Test
    public void test() {
        System.out.println(evaluateTree(TreeUtils.makeTree("[3,3,2,0,0,3,2,null,null,null,null,1,3,1,1,null,null,2,1,null,null,null,null,1,1,null,null,null,null,null,null]")));
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

}
