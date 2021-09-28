package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/path-sum-iii/
 * @Author zouxiaodong
 * @Date 2021/09/28 9:19
 */
//437. 路径总和 III
//        给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//        路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//
//
//        示例 1：
//        输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//        输出：3
//        解释：和等于 8 的路径有 3 条，如图所示。

//        示例 2：
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：3
//
//
//        提示:
//        二叉树的节点个数的范围是 [0,1000]
//        -10^9 <= Node.val <= 10^9
//        -1000 <= targetSum <= 1000
public class PathSum_437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode root,int targetSum){
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    public static void main(String[] args) {
        PathSum_437 pathSum_437 = new PathSum_437();
        TreeNode root = new TreeNode(10);
        TreeNode root_l = new TreeNode(5);
        TreeNode root_l_l = new TreeNode(3);
        TreeNode root_l_l_l = new TreeNode(3);
        TreeNode root_l_l_r = new TreeNode(-1);
        TreeNode root_l_r = new TreeNode(2);
        TreeNode root_l_r_r = new TreeNode(1);
        TreeNode root_r = new TreeNode(-3);
        TreeNode root_r_r = new TreeNode(11);
        root.left = root_l;
        root.right = root_r;
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root_l_l.left = root_l_l_l;
        root_l_l.right = root_l_l_r;
        root_l_r.right = root_l_r_r;
        root_r.right = root_r_r;
        System.out.println(pathSum_437.pathSum(root,8));
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