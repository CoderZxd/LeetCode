package com.zxd.test.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * @Description https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @Author zouxiaodong
 * @Date 2020/09/23 8:13
 */
//617. 合并二叉树
//        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//
//        示例 1:
//
//        输入:
//        Tree 1                     Tree 2
//         1                         2
//        / \                       / \
//       3   2                     1   3
//      /                           \   \
//     5                             4   7
//        输出:
//        合并后的树:
//         3
//        / \
//       4   5
//      / \   \
//     5   4   7
//        注意: 合并必须从两个树的根节点开始。
public class MergeTrees_617 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1_l = new TreeNode(3);
        TreeNode t1_l_l = new TreeNode(5);
        TreeNode t1_r = new TreeNode(2);
        t1.left = t1_l;
        t1.right = t1_r;
        t1_l.left = t1_l_l;
        TreeNode t2 = new TreeNode(2);
        TreeNode t2_l = new TreeNode(1);
        TreeNode t2_l_r = new TreeNode(4);
        TreeNode t2_r = new TreeNode(3);
        TreeNode t2_r_r = new TreeNode(7);
        t2.left = t2_l;
        t2.right = t2_r;
        t2_l.right = t2_l_r;
        t2_r.right = t2_r_r;
        MergeTrees_617 mergeTrees_617 = new MergeTrees_617();
        mergeTrees_617.mergeTrees(t1,t2);
        System.out.println(t1);
        System.out.println();
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }else if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
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