package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import com.lu.utils.JacksonUtil;
import com.lu.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-10-12
 */
public class Tree_q257_0_BinaryTreePaths {

    @Test
    public void test() {
//        System.out.println(JacksonUtil.toJson(binaryTreePaths(TreeUtils.makeTree("[1,2,3,null,5]"))));
    }





    //通过测试用例：
    //206 / 208
    //输入：
    //[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
    //输出：
    //["37->-48->-100","37->-48->-48->48->-54->-71","37->-48->-48->48->-54->-54->->-22->8","37->-48->-48->48->-54->->->-34->-100"]
    //预期结果：
    //["37->-34->-100","37->-48->-100","37->-48->48->-54->-71","37->-48->48->-54->-22->8"]

//    private StringBuilder sb = new StringBuilder();
//    private List<String> res = new ArrayList<>();
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        sb.append(root.val);
//        if (root.right == null && root.left == null) {
//            res.add(sb.toString());
//            return res;
//        }
//        if (root.right!=null) backTracking(root.right);
//        if (root.left!=null)backTracking(root.left);
//        return res;
//    }
//
//    private void backTracking(TreeNode root) {
//        if (root.right == null && root.left == null) {
//            sb.append("->").append(root.val);
//            res.add(sb.toString());
//            sb.delete(sb.lastIndexOf("-"), sb.length());
//            return;
//        }
//        sb.append("->").append(root.val);
//        if (root.left != null) {
//            backTracking(root.left);
//        }
//        sb.delete(sb.lastIndexOf("-"), sb.length());
//
//        sb.append("->").append(root.val);
//        if (root.right != null) {
//            backTracking(root.right);
//        }
//        sb.delete(sb.lastIndexOf("-"), sb.length());
//    }

}
