package com.zxd.test.leetcode;

/**
 * @ClassName HasPathSum_112
 * @Description https://leetcode-cn.com/problems/path-sum/
 * @Author xiaodong.zou
 * @Date 2020/7/7 22:13
 * @Version 1.0
 */
//112. 路径总和
//        给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//         5
//        / \
//       4   8
//      /   / \
//     11  13  4
//    /  \      \
//   7    2      1
//        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
public class HasPathSum_112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_l_l = new TreeNode(11);
        TreeNode root_l_l_l = new TreeNode(7);
        TreeNode root_l_l_r = new TreeNode(2);
        TreeNode root_r = new TreeNode(8);
        TreeNode root_r_l = new TreeNode(13);
        TreeNode root_r_r = new TreeNode(4);
        TreeNode root_r_r_r = new TreeNode(1);
        root.left = root_l;
//        root.right = root_r;
//        root_l.left = root_l_l;
//        root_l_l.left = root_l_l_l;
//        root_l_l.right = root_l_l_r;
//        root_r.left = root_r_l;
//        root_r.right = root_r_r;
//        root_r_r.right = root_r_r_r;
        HasPathSum_112 hasPathSum = new HasPathSum_112();
        System.out.println(hasPathSum.hasPathSum(root,1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */