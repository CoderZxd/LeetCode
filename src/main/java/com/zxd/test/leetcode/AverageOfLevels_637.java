package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName AverageOfLevels_637
 * @Description https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @Author xiaodong.zou
 * @Date 2020/9/12 15:38
 * @Version 1.0
 */
//637. 二叉树的层平均值
//        给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//        示例 1：
//
//        输入：
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        输出：[3, 14.5, 11]
//        解释：
//        第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//
//        提示：
//        节点值的范围在32位有符号整数范围内。
public class AverageOfLevels_637 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_l = new TreeNode(9);
        TreeNode root_l_l = new TreeNode(5);
        TreeNode root_l_r = new TreeNode(6);
        TreeNode root_r = new TreeNode(20);
        TreeNode root_r_l = new TreeNode(15);
        TreeNode root_r_r = new TreeNode(7);
        root.left = root_l;
        root.right = root_r;
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        AverageOfLevels_637 average = new AverageOfLevels_637();
        average.averageOfLevels(root);
    }

//    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Double> resultDoubleList = new ArrayList<>();

    private List<TreeNode> treeNodesList = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        bfs(root, treeNodesList);
        System.out.println(resultDoubleList);
        return resultDoubleList;
    }

    private void bfs(TreeNode root,List<TreeNode> nodesList){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> tempList = new ArrayList<>();
        while (!queue.isEmpty() || !tempList.isEmpty()){
            if(!queue.isEmpty()){
                TreeNode node = queue.poll();
                nodesList.add(node);
                if(node.left != null){
                    tempList.add(node.left);
                }
                if(node.right != null){
                    tempList.add(node.right);
                }
            }else if(!tempList.isEmpty()){
                Double sum = 0.0;
                int size = nodesList.size();
                for(TreeNode node:nodesList){
                    sum += node.val;
                }
                resultDoubleList.add(sum/size);
                nodesList.clear();
                queue.addAll(tempList);
                tempList.clear();
            }
        }
        if(!nodesList.isEmpty()){
            Double sum = 0.0;
            int size = nodesList.size();
            for(TreeNode node:nodesList){
                sum += node.val;
            }
            resultDoubleList.add(sum/size);
        }
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