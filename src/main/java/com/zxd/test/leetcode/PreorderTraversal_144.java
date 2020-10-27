package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Author zouxiaodong
 * @Date 2020/10/27 8:22
 */
//144. 二叉树的前序遍历
//        给定一个二叉树，返回它的 前序 遍历。
//
//        示例:
//
//        输入: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        输出: [1,2,3]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？
public class PreorderTraversal_144 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode root_r = new TreeNode(2);
//        TreeNode root_r_l = new TreeNode(3);
//        root.right = root_r;
//        root_r.left = root_r_l;
        TreeNode root = new TreeNode(3);
        TreeNode root_l = new TreeNode(1);
        TreeNode root_r = new TreeNode(2);
        root.left = root_l;
        root.right = root_r;
        PreorderTraversal_144 preorderTraversal_144 = new PreorderTraversal_144();
        System.out.println(preorderTraversal_144.preorderTraversal(root));
        System.out.println(preorderTraversal_144.preorderTraversal_1(root));
    }


    /**
     * @Author zouxiaodong
     * @Description 递归
     * @Date 2020/10/27 8:29
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root,result);
        return result;
    }

    private void preOrder(TreeNode node,List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        preOrder(node.left,result);
        preOrder(node.right,result);
    }

    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */