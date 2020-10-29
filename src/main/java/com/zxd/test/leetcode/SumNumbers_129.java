package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @Author zouxiaodong
 * @Date 2020/10/29 8:14
 */
//129. 求根到叶子节点数字之和
//        给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//        例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//        计算从根到叶子节点生成的所有数字之和。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例 1:
//
//        输入: [1,2,3]
//        1
//        / \
//        2   3
//        输出: 25
//        解释:
//        从根到叶子节点路径 1->2 代表数字 12.
//        从根到叶子节点路径 1->3 代表数字 13.
//        因此，数字总和 = 12 + 13 = 25.
//        示例 2:
//
//        输入: [4,9,0,5,1]
//        4
//        / \
//        9   0
//        / \
//        5   1
//        输出: 1026
//        解释:
//        从根到叶子节点路径 4->9->5 代表数字 495.
//        从根到叶子节点路径 4->9->1 代表数字 491.
//        从根到叶子节点路径 4->0 代表数字 40.
//        因此，数字总和 = 495 + 491 + 40 = 1026.
public class SumNumbers_129 {

    public static void main(String[] args) {
        SumNumbers_129 sumNumbers_129 = new SumNumbers_129();
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_r = new TreeNode(3);
        TreeNode root_l_l = new TreeNode(5);
        TreeNode root_l_r = new TreeNode(1);
        root.left = root_l;
//        root_l.left = root_l_l;
//        root_l.right = root_l_r;
        root.right = root_r;
        System.out.println(sumNumbers_129.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode node,int val){
        if(node == null){
            return val;
        }
        int sumVal = val*10 + node.val;
        if(node.left != null && node.right != null){
            return dfs(node.left,sumVal) + dfs(node.right,sumVal);
        }else if(node.left != null){
            return  dfs(node.left,sumVal);
        }else {
            return dfs(node.right,sumVal);
        }
    }
}
