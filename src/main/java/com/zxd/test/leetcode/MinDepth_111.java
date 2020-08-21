package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @Author zouxiaodong
 * @Date 2020/08/21 8:22
 */
//111. 二叉树的最小深度
//        给定一个二叉树，找出其最小深度。
//
//        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        给定二叉树 [3,9,20,null,null,15,7],
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回它的最小深度  2.
public class MinDepth_111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_l = new TreeNode(9);
//        TreeNode root_l_l = new TreeNode(5);
        TreeNode root_r = new TreeNode(20);
        TreeNode root_r_l = new TreeNode(15);
        TreeNode root_r_r = new TreeNode(7);
        root_r.left = root_r_l;
        root_r.right = root_r_r;
//        root_l.left = root_l_l;
        root.left = root_l;
        root.right = root_r;
        MinDepth_111 minDepth = new MinDepth_111();
        System.out.println(minDepth.minDepth(root));
        System.out.println(minDepth.minDepth_dfs(root));
        TreeNode root_1 = new TreeNode(1);
        TreeNode root_1_l = new TreeNode(2);
        root_1.left = root_1_l;
        System.out.println(minDepth.minDepth(root_1));
        System.out.println(minDepth.minDepth_dfs(root_1));
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if(root.left == null || root.right == null){
            return Math.max(m1,m2)+1;
        }
        return 1+Math.min(m1,m2);
    }

    public int minDepth_dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(minDepth_dfs(root.left)+1,min_depth);
        }
        if(root.right != null){
            min_depth = Math.min(minDepth_dfs(root.right)+1,min_depth);
        }
        return min_depth;
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