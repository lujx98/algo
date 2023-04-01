package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class Tree_q98_1_IsValidBST {

    @Test
    public void test(){
        System.out.println(isValidBST(TreeUtils.makeTree("[5,1,4,null,null,3,6]")));
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ints = new ArrayList<>();
        travesal(root.left, ints);
        ints.add(root.val);
        travesal(root.right, ints);
        System.out.println(ints);
        return isOrdered(ints);
    }

    private void travesal(TreeNode node, ArrayList<Integer> ints) {
        if (node == null) {
            return;
        }
        travesal(node.left,ints);
        ints.add(node.val);
        travesal(node.right,ints);
    }

    private boolean isOrdered(ArrayList<Integer> ints) {
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i) <= ints.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

//
//    private List<Integer> array = new ArrayList<Integer>();
//
//    public boolean isValidBST(TreeNode root) {
//        travesalBST(root);
//        return isValidBST();
//    }
//
//    private void travesalBST(TreeNode root) {
//        if (root.left != null) {
//            travesalBST(root.left);
//        }
//        array.add(root.val);
//        if (root.right != null) {
//            travesalBST(root.right);
//        }
//    }
//
//    private boolean isValidBST() {
//        int val = array.get(0);
//        for (int i = 1; i < array.size(); i++) {
//            Integer integer = array.get(i);
//            if (integer <= val) {
//                return false;
//            }
//            val = integer;
//        }
//        return true;
//    }

}
