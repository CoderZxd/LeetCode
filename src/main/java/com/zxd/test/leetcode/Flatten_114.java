package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Flatten_114
 * @Description https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @Author xiaodong.zou
 * @Date 2020/8/2 21:47
 * @Version 1.0
 */
//114. 二叉树展开为链表
//        给定一个二叉树，原地将它展开为一个单链表。
//
//
//
//        例如，给定二叉树
//
//         1
//        / \
//       2   5
//      / \   \
//    3   4    6
//        将其展开为：
//
//        1
//         \
//          2
//           \
//            3
//             \
//              4
//               \
//                5
//                 \
//                  6
public class Flatten_114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_r = new TreeNode(5);
        root.left = root_l;
        root.right = root_r;
        TreeNode root_l_l = new TreeNode(3);
        TreeNode root_l_r = new TreeNode(4);
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        TreeNode root_r_r = new TreeNode(6);
        root_r.right = root_r_r;
        Flatten_114 flatten = new Flatten_114();
        flatten.flatten(root);
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        List<Integer> nodes = new ArrayList<>(10);
        pfs(root,nodes);
//        System.out.println(nodes);
        root.left = null;
        TreeNode temp = root;
        int size = nodes.size();
        for(int i=1;i<size;i++){
            temp.right = new TreeNode(nodes.get(i));
            temp = temp.right;
        }
//        System.out.println(root);
    }

    private void pfs(TreeNode node, List<Integer> nodes){
        if(node == null){
            return;
        }
        nodes.add(node.val);
        pfs(node.left,nodes);
        pfs(node.right,nodes);
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