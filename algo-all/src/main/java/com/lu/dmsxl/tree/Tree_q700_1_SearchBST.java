package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class Tree_q700_1_SearchBST {

    @Test
    public void test(){
        System.out.println(searchBST(TreeUtils.makeTree("[4,2,7,1,3]"),2));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val==val){
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }

}
