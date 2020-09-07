package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @Author zouxiaodong
 * @Date 2020/09/07 14:27
 */
//107. 二叉树的层次遍历 II
//        给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回其自底向上的层次遍历为：
//
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
public class LevelOrderBottom_107 {

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
        LevelOrderBottom_107 levelOrderBottom = new LevelOrderBottom_107();
        levelOrderBottom.levelOrderBottom(root);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null && queue.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(tempList);
                resultList.add(temp);
                break;
            }else if(node == null){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(tempList);
                resultList.add(temp);
                tempList.clear();
                queue.offer(null);
                continue;
            }
            tempList.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        int size = resultList.size();
        for(int i=0,j=size-1;i<j;i++,j--){
            List<Integer> temp = resultList.get(i);
            resultList.set(i,resultList.get(j));
            resultList.set(j,temp);
        }
        return resultList;
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