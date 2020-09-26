package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathSum_113
 * @Description https://leetcode-cn.com/problems/path-sum-ii/
 * @Author xiaodong.zou
 * @Date 2020/9/26 19:39
 * @Version 1.0
 */
//113. 路径总和 II
//        给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//        返回:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
public class PathSum_113 {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root_l = new TreeNode(4);
        TreeNode root_l_l = new TreeNode(11);
        TreeNode root_l_l_l = new TreeNode(7);
        TreeNode root_l_l_r = new TreeNode(2);
        TreeNode root_r = new TreeNode(8);
        TreeNode root_r_l = new TreeNode(13);
        TreeNode root_r_r = new TreeNode(4);
        TreeNode root_r_r_l = new TreeNode(5);
        TreeNode root_r_r_r = new TreeNode(1);
        root.left = root_l;
        root.right = root_r;
        root_l.left = root_l_l;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        root_l_l.left = root_l_l_l;
        root_l_l.right = root_l_l_r;
        root_r_r.left = root_r_r_l;
        root_r_r.right = root_r_r_r;
        PathSum_113 pathSum113 = new PathSum_113();
        System.out.println(pathSum113.pathSum(root,22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return result;
    }

    private void dfs(TreeNode node,int val){
        if(node == null){
            return;
        }
        tempList.add(node.val);
        val -= node.val;
        if(node.left == null && node.right == null && val == 0){
            result.add(new ArrayList<>(tempList));
        }
        dfs(node.left,val);
        dfs(node.right,val);
        tempList.remove(tempList.size()-1);
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