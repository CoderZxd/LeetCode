package com.zxd.test.leetcode;

/**
 * @ClassName SumOfLeftLeaves_404
 * @Description https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @Author xiaodong.zou
 * @Date 2020/9/19 17:54
 * @Version 1.0
 */
//404. 左叶子之和
//        计算给定二叉树的所有左叶子之和。
//
//        示例：
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//
//        在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
public class SumOfLeftLeaves_404 {

    int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_l = new TreeNode(9);
        TreeNode root_r = new TreeNode(20);
        TreeNode root_r_l = new TreeNode(15);
        TreeNode root_r_r = new TreeNode(7);
        root.left = root_l;
        root.right = root_r;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        SumOfLeftLeaves_404 sumOfLeftLeaves_404 = new SumOfLeftLeaves_404();
        System.out.println(sumOfLeftLeaves_404.sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves_404.sumOfLeftLeaves_recursive(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return sum;
    }

    private void dfs(TreeNode node,boolean isLeft){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(isLeft){
                sum += node.val;
            }
            return;
        }
        dfs(node.left,true);
        dfs(node.right,false);
    }


    /**
     * 解法二：递归
     * @param root
     * @return
     */
    public int sumOfLeftLeaves_recursive(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumOfLeftLeaves_recursive(root.left) + sumOfLeftLeaves_recursive(root.right) + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val:0);
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