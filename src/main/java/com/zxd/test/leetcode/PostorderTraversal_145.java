package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @Author zouxiaodong
 * @Date 2020/09/29 8:03
 */
//145. 二叉树的后序遍历
//        给定一个二叉树，返回它的 后序 遍历。
//
//        示例:
//
//        输入: [1,null,2,3]
//        1
//         \
//         2
//        /
//       3
//
//        输出: [3,2,1]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？
public class PostorderTraversal_145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_r = new TreeNode(2);
        TreeNode root_r_l = new TreeNode(3);
        root.right = root_r;
        root_r.left = root_r_l;
        PostorderTraversal_145 postorderTraversal145 = new PostorderTraversal_145();
//        List<Integer> result = postorderTraversal145.postorderTraversal(root);
        List<Integer> result = postorderTraversal145.postorderTraversal_1(root);
        System.out.println(result);
    }

    /**
     * @Author zouxiaodong
     * @Description 解法一：递归
     * @Date 2020/09/29 8:10
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root,result);
        return result;
    }

    private void postOrder(TreeNode node,List<Integer> result){
        if(node == null){
            return;
        }
        postOrder(node.left,result);
        postOrder(node.right,result);
        result.add(node.val);
    }

    /**
     * @Author zouxiaodong
     * @Description 解法二：迭代
     * @Date 2020/09/29 8:20
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
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