package com.zxd.test.leetcode;

/**
 * @ClassName MaxDepth_104
 * @Description https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Author xiaodong.zou
 * @Date 2020/7/28 22:03
 * @Version 1.0
 */
//104. 二叉树的最大深度
//        给定一个二叉树，找出其最大深度。
//
//        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例：
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回它的最大深度 3 。
public class MaxDepth_104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_left = new TreeNode(9);
        TreeNode root_right = new TreeNode(20);
        TreeNode right = new TreeNode(7);
        TreeNode left = new TreeNode(15);
        root.left = root_left;
        root.right = root_right;
        root_right.left = left;
        root_right.right = right;
        MaxDepth_104 maxDepth = new MaxDepth_104();
        System.out.println(maxDepth.maxDepth(root));

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth((root.right)));
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