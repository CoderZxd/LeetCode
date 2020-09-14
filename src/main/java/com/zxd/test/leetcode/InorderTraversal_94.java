package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Author zouxiaodong
 * @Date 2020/09/14 8:10
 */
//94. 二叉树的中序遍历
//        给定一个二叉树，返回它的中序 遍历。
//
//        示例:
//
//        输入: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        输出: [1,3,2]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？
public class InorderTraversal_94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_r = new TreeNode(2);
        TreeNode root_r_l = new TreeNode(3);
        root.right = root_r;
        root_r.left = root_r_l;
        InorderTraversal_94 inorderTraversal_94 = new InorderTraversal_94();
        System.out.println(inorderTraversal_94.inorderTraversal(root));

    }

    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return resultList;
    }

    /**
     * @Author zouxiaodong
     * @Description 递归
     * @Date 2020/09/14 8:22
     * @Param [node]
     * @return void
     **/
    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        resultList.add(node.val);
        inOrder(node.right);
    }


    /**
     * @Author zouxiaodong
     * @Description 迭代
     * @Date 2020/09/14 8:42
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
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