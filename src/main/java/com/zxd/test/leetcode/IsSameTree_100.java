package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/same-tree/
 * @Author zouxiaodong
 * @Date 2020/08/07 8:08
 */
//100. 相同的树
//        给定两个二叉树，编写一个函数来检验它们是否相同。
//        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//        示例 1:
//
//        输入:       1         1
//                  / \       / \
//                 2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//        输出: true

//        示例 2:
//
//        输入:      1          1
//                  /           \
//                 2             2
//
//                [1,2],     [1,null,2]
//
//        输出: false

//        示例 3:
//
//        输入:        1         1
//                   / \       / \
//                  2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//        输出: false
public class IsSameTree_100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(3);
        p.left = left;
//        p.right = right;
        TreeNode q = new TreeNode(1);
//        TreeNode q_left = new TreeNode(3);
        TreeNode q_right = new TreeNode(1);
//        q.left = q_left;
        q.right = q_right;
        IsSameTree_100 isSameTree = new IsSameTree_100();
        System.out.println(isSameTree.isSameTree(p,q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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