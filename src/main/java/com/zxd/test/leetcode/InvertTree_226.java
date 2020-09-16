package com.zxd.test.leetcode;

/**
 * @ClassName InvertTree_226
 * @Description https://leetcode-cn.com/problems/invert-binary-tree/
 * @Author xiaodong.zou
 * @Date 2020/9/16 19:56
 * @Version 1.0
 */
//226. 翻转二叉树
//        翻转一棵二叉树。
//
//        示例：
//
//        输入：
//
//          4
//        /   \
//       2     7
//      / \   / \
//     1   3 6   9

//        输出：
//
//          4
//        /   \
//       7     2
//      / \   / \
//    9   6 3   1
//        备注:
//        这个问题是受到 Max Howell 的 原问题 启发的 ：
//
//        谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
public class InvertTree_226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_l_l = new TreeNode(1);
        TreeNode root_l_r = new TreeNode(3);
        TreeNode root_r = new TreeNode(7);
        TreeNode root_r_l = new TreeNode(6);
        TreeNode root_r_r = new TreeNode(9);
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        root.left = root_l;
        root.right = root_r;
        InvertTree_226 invertTree_226 = new InvertTree_226();
        invertTree_226.invertTree(root);
        System.out.println(root);
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        TreeNode left = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = left;
        dfs(treeNode.left);
        dfs(treeNode.right);
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