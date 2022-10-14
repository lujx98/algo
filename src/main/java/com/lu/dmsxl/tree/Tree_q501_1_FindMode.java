package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-05-09
 */
public class Tree_q501_1_FindMode {

    @Test
    public void test() {

    }

    private ArrayList<Integer> res;
    int count = 0;
    int maxCount = 0;
    TreeNode pre;

    public int[] findMode(TreeNode root) {

        travesal(root);

        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }

        return ints;
    }

    private void travesal(TreeNode root) {
        if (root == null) {
            return;
        }

        travesal(root.left);
        if (pre == null || !Objects.equals(pre.val, root.val)) {
            count = 1;
        } else {
            count++;
        }
        pre = root;

        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(root.val);
        }

        travesal(root.right);

    }

//    private int maxcount;
//    private int count;
//    private ArrayList<Integer> result = new ArrayList<>();
//    private TreeNode previousNode = null;
//
//    public int[] findMode(TreeNode root) {
//        traversal(root);
//        int[] res = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            res[i] = result.get(i);
//        }
//        return res;
//    }
//
//    private void traversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        traversal(root.left);
//        if (previousNode == null || previousNode.val != root.val) {
//            count = 1;
//        } else {
//            count ++;
//        }
//
//        if (count>maxcount) {
//            maxcount = count;
//            result.clear();
//            result.add(root.val);
//        }else if (count == maxcount){
//            result.add(root.val);
//        }
//
//        previousNode = root;
//        traversal(root.right);
//    }

}
