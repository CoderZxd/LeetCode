package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Author zouxiaodong
 * @Date 2020/12/22 8:57
 */
//103. 二叉树的锯齿形层序遍历
//        给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回锯齿形层序遍历如下：
//
//        [
//         [3],
//         [20,9],
//         [15,7]
//        ]
public class ZigzagLevelOrder_103 {


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
        ZigzagLevelOrder_103 zigzagLevelOrder_103 = new ZigzagLevelOrder_103();
        System.out.println(zigzagLevelOrder_103.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        boolean isOrderLeft = true;
        while (!treeNodeQueue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size = treeNodeQueue.size();
            for(int i=0;i<size;i++){
                TreeNode node = treeNodeQueue.poll();
                if(isOrderLeft){
                    levelList.add(node.val);
                }else{
                    levelList.add(0,node.val);
                }
                if(node.left != null){
                    treeNodeQueue.offer(node.left);
                }
                if(node.right != null){
                    treeNodeQueue.offer(node.right);
                }
            }
            resultList.add(new ArrayList<>(levelList));
            isOrderLeft=!isOrderLeft;
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