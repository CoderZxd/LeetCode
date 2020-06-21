package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MaxPathSum_124
 * @Description https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @Author xiaodong.zou
 * @Date 2020/6/21 10:15
 * @Version 1.0
 */
//124. 二叉树中的最大路径和
//        给定一个非空二叉树，返回其最大路径和。
//
//        本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
//        示例 1:
//
//        输入: [1,2,3]
//
//         1
//        / \
//       2   3
//
//        输出: 6
//        示例 2:
//
//        输入: [-10,9,20,null,null,15,7]
//
//        -10
//        / \
//       9  20
//         / \
//        15  7
//
//        输出: 42
public class MaxPathSum_124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node_2_2 = new TreeNode(-2);
        TreeNode node_1 = new TreeNode(-1);
        root.left=node_2;
        root.right=node_3;
        node_2.left=node1;
        node_2.right=node3;
        node_3.left = node_2_2;
        node1.left=node_1;
        MaxPathSum_124 maxPathSum_124 = new MaxPathSum_124();
        System.out.println(maxPathSum_124.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>(10);
        inOrder(root,inOrderList);
        System.out.println(inOrderList);
        int size = inOrderList.size();
        int[] dp = new int[size];
        dp[0] = inOrderList.get(0);
        for(int i=1;i<size;i++){
            dp[i] = inOrderList.get(i)>=0?(inOrderList.get(i-1)<0?(inOrderList.get(i-1)+dp[i-1]>=0?dp[i-1]+inOrderList.get(i-1)+inOrderList.get(i):inOrderList.get(i)):inOrderList.get(i)+dp[i-1]):(dp[i-1]>inOrderList.get(i)?dp[i-1]:inOrderList.get(i));
        }
        return dp[size-1];
    }

    private void inOrder(TreeNode node,List<Integer> inOrderList){
        if(node == null){
            return;
        }
        inOrder(node.left,inOrderList);
        inOrderList.add(node.val);
        inOrder(node.right,inOrderList);
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
