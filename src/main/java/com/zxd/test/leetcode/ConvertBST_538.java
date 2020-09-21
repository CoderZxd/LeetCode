package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @Author zouxiaodong
 * @Date 2020/09/21 8:27
 */
//538. 把二叉搜索树转换为累加树
//        给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
//
//        例如：
//
//        输入: 原始二叉搜索树:
//          5
//         / \
//        3   13
//       /\   /\
//      2  4 10 15
//        输出: 转换为累加树:
//           43
//         /   \
//        50    28
//        / \   / \
//       52 47 38 15
//        注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
public class ConvertBST_538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root_l = new TreeNode(3);
        TreeNode root_l_l = new TreeNode(2);
        TreeNode root_l_r = new TreeNode(4);
        TreeNode root_r = new TreeNode(13);
        TreeNode root_r_l = new TreeNode(10);
        TreeNode root_r_r = new TreeNode(15);
        root.left = root_l;
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root.right = root_r;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        ConvertBST_538 convertBST_538 = new ConvertBST_538();
        convertBST_538.convertBST(root);
        System.out.println(root);
    }

    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
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